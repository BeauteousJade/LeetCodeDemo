package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 751. IP 到 CIDR -- 贪心。
 * <p>
 * https://leetcode.cn/problems/ip-to-cidr/?favorite=qg88wci
 */
public class IpToCIDRDemo {

    public static void main(String[] args) {
        IpToCIDRDemo demo = new IpToCIDRDemo();

        System.out.println(demo.ipToCIDR("255.0.0.7", 10));
    }

    /**
     * 基本思想，以ip为start,逐渐遍历,计算每个每个IP的CIDR 能覆盖多少个IP，直到最后一个ip。
     * 一个ip是否能够以CIDR代替多个，得看ip低位是否为0:
     * 1. 如果不为0，那么CIDR只能代替一个。例如： 255.0.0.9 -> 11111111 00000000 00000000 00001001 -> 255.0.0.9/32
     * 2. 如果为0，那么CIDR可以代替多个。例如：255.0.0.8 -> 11111111 00000000 00000000 00001000 -> 255.0.0.8/29
     */
    public List<String> ipToCIDR(String ip, int n) {
        int start = toInt(ip);//将ip转化为整数
        List<String> ans = new ArrayList<>();
        while (n > 0) {
            // 获取低位0的个数。
            int trailingZeros = Integer.numberOfTrailingZeros(start);
            // 计算Ip低位有几位可以被CIDR代替。
            int mask = 0;
            // 表示当前CIDR代表Ip的个数。
            int bitsInCIDR = 1;
            // 计算mask
            while (bitsInCIDR < n && mask < trailingZeros) {
                bitsInCIDR <<= 1;
                mask++;
            }
            // 如果bitsInCIDR 代表的个数超过了n,此时需要回退。
            if (bitsInCIDR > n) {
                bitsInCIDR >>= 1;
                mask--;
            }

            ans.add(toString(start, 32 - mask));
            n -= bitsInCIDR;
            start += (bitsInCIDR);
        }
        return ans;
    }

    private String toString(int number, int range) {
        final int WORD_SIZE = 8;
        StringBuilder buffer = new StringBuilder();
        for (int i = 3; i >= 0; --i) {
            buffer.append(((number >> (i * WORD_SIZE)) & 255));
            buffer.append(".");
        }
        buffer.setLength(buffer.length() - 1);
        buffer.append("/").append(range);
        return buffer.toString();
    }

    private int toInt(String ip) {
        String[] strs = ip.split("\\.");
        int sum = 0;
        for (String str : strs) {
            sum = sum * 256 + Integer.parseInt(str);
        }
        return sum;
    }
}
