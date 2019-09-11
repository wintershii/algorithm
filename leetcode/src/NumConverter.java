/**
 * 数字转化汉字
 * 美团笔试题
 */
public class NumConverter {
    public static void main(String[] args) {
        System.out.println(numberToChinese("20000101011.11"));
    }

    public static String numberToChinese(String numStr){
        String[] jihe = numStr.split("\\.");
        String zhengshu = jihe[0];
        long num = Long.parseLong(zhengshu);
        StringBuilder result = new StringBuilder();
        long _num = num;
        String[] chnStr = new String[] { "零","壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String[] sectionValue = new String[] { "","万","亿","万亿"};
        String[] unitValue = new String[] { "", "拾", "佰", "仟" };
        int section = (int)(_num % 10000);
        if (num != 0)
        {

            for (int i = 0; _num != 0 && i < 4; i++)
            {
                if (section == 0)
                {
                    //0不需要考虑节权值，不能出现连续的“零”
                    if (result.length() > 0 && !result.substring(0, 1).equals("零"))
                    {
                        result.insert(0, "零");
                    }
                    _num = _num / 10000;
                    section = (int)(_num % 10000);
                    continue;
                }
                result.insert(0, sectionValue[i]);
                int unit = (int)(section % 10);
                for (int j = 0; j<4 ; j++)
                {
                    if (unit == 0)
                    {
                        //0不需要考虑位权值，不能出现联系的“零”，每节最后的0不需要
                        if (result.length() > 0 && !result.substring(0, 1).equals("零") && !result.substring(0, 1).equals(sectionValue[i]))
                        {
                            result.insert(0, "零");
                        }
                    }
                    else
                    {
                        result.insert(0, chnStr[unit] + unitValue[j]);
                    }
                    section = section / 10;
                    unit = section % 10;
                }
                _num = _num / 10000;
                section = (int)(_num % 10000);
            }
            if (result.length() > 0 && result.substring(0, 1).equals("零"))
            {
                //清理最前面的"零"
                result = new StringBuilder(result.substring(1));
            }
            result.append("元");

            if (jihe.length < 2) {
                return result.append("整").toString();
            }
            String xiaoshu = numStr.split("\\.")[1];
            if (xiaoshu.length() == 1) {
                xiaoshu += "0";
            }
            int num2 = Integer.parseInt(xiaoshu);
            if (num2 == 0) {
                return result.append("整").toString();
            }
            int a = num2 / 10;
            int b = num2 % 10;
            result.append(chnStr[a]);
            if (a != 0) {
                result.append("角");
            }
            if (b != 0) {
                result.append(chnStr[b]).append("分");
            }

            return result.toString();
        } else {
            String xiaoshu = numStr.split("\\.")[1];
            if (xiaoshu.length() == 1) {
                xiaoshu += "0";
            }
            int num2 = Integer.parseInt(xiaoshu);
            if (num2 == 0) {
                return result.append("零").toString();
            }
            int a = num2 / 10;
            int b = num2 % 10;
            if (a != 0) {
                result.append(chnStr[a]);
                result.append("角");
            }
            if (b != 0) {
                result.append(chnStr[b]).append("分");
            }

            return result.toString();
        }

    }
}
