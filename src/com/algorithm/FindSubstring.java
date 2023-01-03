package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所有单词的子串 leetcode30
 * 滑动窗口+哈希表
 */
public class FindSubstring {
    public static void main(String[] args) {
        String str = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] strArr = new String[]{"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb"};
//        String str = "aaa";
//        String[] strArr = new String[]{"a", "a"};
        for (Integer integer : findSubstring(str, strArr)) {
            System.out.println(integer);
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || words == null) {
            return ans;
        }
        int sLen = s.length();
        int wordsLen = words.length;
        int wordLen = words[0].length();
        if (wordsLen * wordLen > sLen) {
            return ans;
        }
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (String str : words) {
            if (wordsMap.containsKey(str)) {
                wordsMap.put(str, wordsMap.get(str) + 1);
            } else {
                wordsMap.put(str, 1);
            }
        }
        HashMap<String, Integer> tempMap = new HashMap<>();
        for (int i = 0; i <= s.length() - wordLen * wordsLen; i++) {
            tempMap.clear();
            int index = i;
            int j = index;
            for (; j < index + wordsLen * wordLen; j = j + wordLen) {
                if (!wordsMap.containsKey(s.substring(j, j + wordLen))) {
                    break;
                }
                if (tempMap.containsKey(s.substring(j, j + wordLen))) {
                    tempMap.put(s.substring(j, j + wordLen), tempMap.get(s.substring(j, j + wordLen)) + 1);
                } else {
                    tempMap.put(s.substring(j, j + wordLen), 1);
                }
                if (tempMap.get(s.substring(j, j + wordLen)) > wordsMap.get(s.substring(j, j + wordLen))) {
                    break;
                }
            }
            if (j == index + wordLen * wordsLen) {
                ans.add(index);
            }
        }
        return ans;
    }
}
