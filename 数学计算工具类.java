/**
 * <p>Description: [数字计算工具类]</p>
 * @version 1.0
 */
public class MathUtils {
 
    /** 一百的常量 */
    private static final int HUNDRED_NUMBER = 100;
 
    /** 默认保留小数位数 */
    private static final int DEFAULT_DECIMAL_NUMBER = 2;
 
    /** 正则：整数（int） */
    private static final Pattern intPattern = Pattern.compile("^[-\\+]?[\\d]*$");
 
    /** 正则：浮点数（double和float） */
    private static final Pattern dfPattern = Pattern.compile("^[-\\+]?\\d*[.]\\d+$");
 
    /** 正则：特殊字符（） */
    private static final Pattern specialPattern = Pattern.compile("[^a-zA-Z0-9]");
 
 
    /**
     *  <p>Description:[根据两个整数获取BigDecimal数值]</p>
     * @param a 分子数字
     * @param b 分母数字
     * @return BigDecimal 保留4位小数返回值
     */
    public static BigDecimal getBigDecimal(int a, int b) {
        if (b == 0) {
            return new BigDecimal(0).setScale(DEFAULT_DECIMAL_NUMBER, BigDecimal.ROUND_HALF_UP);
        }
        return new BigDecimal((float)a/b).setScale(DEFAULT_DECIMAL_NUMBER, BigDecimal.ROUND_HALF_UP);
    }
 
    /**
     *  <p>Description:[根据两个整数获取BigDecimal数值]</p>
     * @param a 分子数字
     * @param b 分母数字
     * @return BigDecimal 保留4位小数返回值
     */
    public static BigDecimal getBigDecimal(long a, long b) {
        if (b == 0) {
            return new BigDecimal(0).setScale(DEFAULT_DECIMAL_NUMBER, BigDecimal.ROUND_HALF_UP);
        }
        return new BigDecimal((float)a/b).setScale(DEFAULT_DECIMAL_NUMBER, BigDecimal.ROUND_HALF_UP);
    }
 
    /**
     *  <p>Description:[根据两个整数获取BigDecimal数值]</p>
     * @param a 分子数字
     * @param b 分母数字
     * @return BigDecimal 保留4位小数返回值
     */
    public static BigDecimal getBigDecimal(double a, double b) {
        if (b == 0) {
            return new BigDecimal(0).setScale(DEFAULT_DECIMAL_NUMBER, BigDecimal.ROUND_HALF_UP);
        }
        return new BigDecimal((float)a/b).setScale(DEFAULT_DECIMAL_NUMBER, BigDecimal.ROUND_HALF_UP);
    }
 
    /**
     *  <p>Description:[计算一个数值的百分比字符串，保留两位小数]</p>
     * @param bigDecimal 参数
     * @return String 保留2位小数返回值
     */
    public static String getPercentBigDecimal(BigDecimal bigDecimal) {
        return getBigDecimal(bigDecimal.multiply(new BigDecimal(HUNDRED_NUMBER)), DEFAULT_DECIMAL_NUMBER).toString() + "%";
    }
 
    /**
     *  <p>Description:[BigDecimal保留对应的小数位数]</p>
     * @param bigDecimal 数据参数
     * @param scale 保留小数位数
     * @return BigDecimal 保留小数后的数据
     */
    public static BigDecimal getBigDecimal(BigDecimal bigDecimal, int scale) {
        return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }
 
    /**
     *  <p>Description:[BigDecimal保留两位小数位数]</p>
     * @param bigDecimal 数据参数
     * @return BigDecimal 保留两位小数后的数据
     */
    public static BigDecimal getBigDecimal(BigDecimal bigDecimal) {
        return bigDecimal.setScale(DEFAULT_DECIMAL_NUMBER, BigDecimal.ROUND_HALF_UP);
    }
 
    /**
     *  <p>Description:[计算数值1在数值2的占比字符串，保留两位小数]</p>
     * @param int1 参数1
     * @param int2 参数2
     * @return String 保留2位小数返回值
     */
    public static String getPercent(int int1, int int2){
        if(int1 == 0 || int2 == 0){
            return "0.00%";
        }
 
        DecimalFormat df = new DecimalFormat("0.00");
        double d0 = (float)int1/int2 * 100;
        return df.format(d0) + "%";
    }
 
    public static BigDecimal getMultiply(BigDecimal a, BigDecimal b){
        BigDecimal zero = new BigDecimal(0);
        if(zero.equals(a) || zero.equals(b)){
            return zero;
        }
        return getBigDecimal(a.multiply(b));
    }
 
 
    /**
     * 判断整数（int）
     * @param str   字符串
     * @return  true 是, false 否
     */
    public static boolean isInteger(String str) {
        if (null == str || "".equals(str.trim())) {
            return false;
        }
        return intPattern.matcher(str.trim()).matches();
    }
 
    /**
     * 判断浮点数（double和float）
     * @param str   字符串
     * @return  true 是, false 否
     */
    public static boolean isDouble(String str) {
        if (null == str || "".equals(str.trim())) {
            return false;
        }
        return dfPattern.matcher(str.trim()).matches();
    }
 
    /**
     * 判断特殊字符
     * @param str   字符串
     * @return  true 是, false 否
     */
    public static boolean isSpecial(String str){
        if (null == str || "".equals(str.trim())){
            return false;
        }
        return specialPattern.matcher(str.trim()).matches();
    }
 
}
