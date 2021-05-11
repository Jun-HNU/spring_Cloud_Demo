package springcloud.entities;

import cn.hutool.core.codec.Base64Encoder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Base64;

/**
 * @auther zzyy
 * @create 2020-02-18 17:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable
{
    private Long id;
    private String serial;
//普通字符串可以转为base编码类型的字符串，需要先转化为byte数组。
    /**
     * ASII码表，与base64表
     * 1.base64是8bit字节代码的编码方式之一。
     *  包含大小写字母52个,+,/，共64个字符进行排序得到编码表，序号为表的索引，填充字符=。
     * 2.byte中存放的数字，就是ASCII码中的十进制中的值。byte类型数据包含8个字节，即为8个bit
     * 3.p字符串中字字符为ASCII码中的图形
     * 4.首先每个所有字符转换为ASCII码值的2进制表示，每个字符对应8个2进制
     * (即ASII码中每个字符对应为一个10进制或者2进制的值)，8那个2进制按照6个为一组，
     * 最后一组不足的部分向右补0，这个包含6个bit的二进制字符串转化为10进制后，对应base64编码表
     * 中的索引，这样每一组二进制都可可对应一个base64中的可打印字符。
     * 在base64的编码对照表中，通过查询索引可以得到编码后的结果。
     *
     * byte数组经过base64编码后得到的字符串结果为长度为必须为4的整数倍，不足部分加上填充字符=,
     * byte 0转化为base64后为AA==。
     *
     *
     */

    public static void main(String[] args) {
        String A="Ma";
        //String A=null;

        byte[] aBytes = A.getBytes();
        Base64Encoder Encoder = new Base64Encoder();
        String aenStr = Encoder.encode(aBytes);
        System.out.println(aenStr);
        System.out.println(aBytes);

        //byte[] bytes={77,97};
        byte[] bytes={0};
        String benStr = Encoder.encode(bytes);
        System.out.println("ok");
    }
}
