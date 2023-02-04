package disjointSet;

import java.util.*;

/**
 * 737. 句子相似性 II -- 并查集。
 * <p>
 * https://leetcode.cn/problems/sentence-similarity-ii/?favorite=qg88wci
 */
public class AreSentencesSimilarDemoV2 {


    public static void main(String[] args) {
        AreSentencesSimilarDemoV2 demo = new AreSentencesSimilarDemoV2();

        String[] array1 = {"jrocadcojmybpxmuj", "livgsrfvgtovcurzq", "mnrdscqkycodx", "wgcjlntupylayse", "tglnshmqlmkqqfbpf", "uzlxmaoro", "narvuaqmmkqhd", "xozoyaqxtbustrymo", "jrocadcojmybpxmuj", "ainlwrwabqcwq", "qnjidlmwmxxjgntez", "bbchthovla", "vaufbmwdrupcxpg", "zwwgloilddclufwze", "tyxrlpmcy", "wtjtdrlm", "edurtetzseifez", "yzxogkunvohdmro", "livgsrfvgtovcurzq", "wmpvjvzljhnaxvp", "rqbswlkw", "umlzibkkpsyvpdol", "jkcmceinlyhi", "wlvmfxbleuot", "aeloeauxmc", "ooyllkxg", "wlvmfxbleuot", "cuewcvuy", "vaufbmwdrupcxpg", "bbchthovla", "arigdtezmyz", "yzxogkunvohdmro", "wrszraxxdum", "dhmiuqhqlsprxy", "xpmxtfyvjrnujyxjh", "bfxbncez", "cjjkmybleu", "mnrdscqkycodx", "mzfpofjn", "livgsrfvgtovcurzq", "shfzcyboj", "xozoyaqxtbustrymo", "xozoyaqxtbustrymo", "orlzzpytpzazxr", "filnwifbukdqijgr", "fllqjtnxwmfoou", "mkmawbogphdttd", "rthpxoxyyiy", "dkhfozltuckwog", "wmpvjvzljhnaxvp", "dhmiuqhqlsprxy", "yltljjairlkrmdq", "cuewcvuy", "subzoyxjkfiwmfb", "mzvbgcizeeth", "narvuaqmmkqhd", "tglnshmqlmkqqfbpf", "rpesfkhfjucj", "xrgfejybbkezgor", "vaufbmwdrupcxpg", "czlgbqzffodsoxng", "suvvqdiceuogcmv", "fllqjtnxwmfoou", "yltljjairlkrmdq", "bubwouozgs", "mnrdscqkycodx", "rqbswlkw", "ooyllkxg", "livgsrfvgtovcurzq", "rthpxoxyyiy", "pyzcbpjhntpefbq", "wtjtdrlm", "rztcppnmud", "inuzvkgolupxelcal", "pdxsxjop", "wmpvjvzljhnaxvp", "xydwvemqvtgvzl", "hqpnoczciajvkbdy", "rvihrzzkt", "jzquemjzpvfbka", "gkqrglav", "qyaxqaqxiwr", "mzvbgcizeeth", "umlzibkkpsyvpdol", "vaufbmwdrupcxpg", "ooyllkxg", "arigdtezmyz", "bubwouozgs", "wtjtdrlm", "xozoyaqxtbustrymo", "jrocadcojmybpxmuj", "rnlryins", "fllqjtnxwmfoou", "livgsrfvgtovcurzq", "czlgbqzffodsoxng", "hlcsiukaroscfg", "bfxbncez", "ainlwrwabqcwq", "vaufbmwdrupcxpg", "vaufbmwdrupcxpg"};
        String[] array2 = {"jrocadcojmybpxmuj", "livgsrfvgtovcurzq", "mnrdscqkycodx", "wgcjlntupylayse", "bbchthovla", "bfxbncez", "ztisufueqzequ", "yutahdply", "suvvqdiceuogcmv", "ainlwrwabqcwq", "fquzrlhdsnuwhhu", "tglnshmqlmkqqfbpf", "vaufbmwdrupcxpg", "zwwgloilddclufwze", "livgsrfvgtovcurzq", "wtjtdrlm", "edurtetzseifez", "ecqfdkebnamkfglk", "livgsrfvgtovcurzq", "wmpvjvzljhnaxvp", "ryubcgbzmxc", "pzlmeboecybxmetz", "hqpnoczciajvkbdy", "xpmxtfyvjrnujyxjh", "zwwgloilddclufwze", "khcyhttaaxp", "wlvmfxbleuot", "jzquemjzpvfbka", "vaufbmwdrupcxpg", "tglnshmqlmkqqfbpf", "mzvbgcizeeth", "cjjkmybleu", "orlzzpytpzazxr", "dhmiuqhqlsprxy", "mzfpofjn", "bfxbncez", "inuzvkgolupxelcal", "inhzsspqltvl", "wlvmfxbleuot", "livgsrfvgtovcurzq", "orlzzpytpzazxr", "yutahdply", "yutahdply", "orlzzpytpzazxr", "gdziaihbagl", "yltljjairlkrmdq", "mkmawbogphdttd", "aotjpvanljxe", "aeloeauxmc", "wmpvjvzljhnaxvp", "dhmiuqhqlsprxy", "yltljjairlkrmdq", "dnaaehrekqms", "khcyhttaaxp", "mzvbgcizeeth", "narvuaqmmkqhd", "rvihrzzkt", "bfufqsusp", "xrgfejybbkezgor", "vaufbmwdrupcxpg", "czlgbqzffodsoxng", "jrocadcojmybpxmuj", "yltljjairlkrmdq", "yltljjairlkrmdq", "bubwouozgs", "inhzsspqltvl", "bsybvehdny", "subzoyxjkfiwmfb", "livgsrfvgtovcurzq", "stkglpqdjzxmnlito", "evepphnzuw", "xrgfejybbkezgor", "rztcppnmud", "cjjkmybleu", "qyaxqaqxiwr", "ibwfxvxswjbecab", "xydwvemqvtgvzl", "hqpnoczciajvkbdy", "tglnshmqlmkqqfbpf", "dnaaehrekqms", "gkqrglav", "bfxbncez", "qvwvgzxqihvk", "umlzibkkpsyvpdol", "vaufbmwdrupcxpg", "khcyhttaaxp", "arigdtezmyz", "bubwouozgs", "fllqjtnxwmfoou", "xozoyaqxtbustrymo", "jrocadcojmybpxmuj", "rnlryins", "wtjtdrlm", "livgsrfvgtovcurzq", "gkqrglav", "orileazg", "uzlxmaoro", "ainlwrwabqcwq", "vaufbmwdrupcxpg", "vaufbmwdrupcxpg"};
        String[][] array3 = {{"yutahdply", "yutahdply"}, {"xozoyaqxtbustrymo", "xozoyaqxtbustrymo"}, {"xozoyaqxtbustrymo", "xozoyaqxtbustrymo"}, {"yutahdply", "yutahdply"}, {"bsybvehdny", "bsybvehdny"}, {"pzlmeboecybxmetz", "pzlmeboecybxmetz"}, {"rqbswlkw", "rqbswlkw"}, {"ryubcgbzmxc", "ryubcgbzmxc"}, {"umlzibkkpsyvpdol", "umlzibkkpsyvpdol"}, {"bsybvehdny", "bsybvehdny"}, {"rqbswlkw", "bsybvehdny"}, {"pzlmeboecybxmetz", "bsybvehdny"}, {"ryubcgbzmxc", "ryubcgbzmxc"}, {"umlzibkkpsyvpdol", "ryubcgbzmxc"}, {"hqpnoczciajvkbdy", "hqpnoczciajvkbdy"}, {"vdjccijgqk", "vdjccijgqk"}, {"rztcppnmud", "rztcppnmud"}, {"jkcmceinlyhi", "hqpnoczciajvkbdy"}, {"vdjccijgqk", "vdjccijgqk"}, {"rztcppnmud", "vdjccijgqk"}, {"hqpnoczciajvkbdy", "hqpnoczciajvkbdy"}, {"jkcmceinlyhi", "hqpnoczciajvkbdy"}, {"suvvqdiceuogcmv", "llrzqdnoxbscnkqy"}, {"jrocadcojmybpxmuj", "jrocadcojmybpxmuj"}, {"suvvqdiceuogcmv", "suvvqdiceuogcmv"}, {"llrzqdnoxbscnkqy", "suvvqdiceuogcmv"}, {"jrocadcojmybpxmuj", "jrocadcojmybpxmuj"}, {"dnaaehrekqms", "dnaaehrekqms"}, {"jzquemjzpvfbka", "muaskefecskjghzn"}, {"muaskefecskjghzn", "iziepzqne"}, {"cuewcvuy", "dnaaehrekqms"}, {"iziepzqne", "iziepzqne"}, {"muaskefecskjghzn", "iziepzqne"}, {"jzquemjzpvfbka", "iziepzqne"}, {"dnaaehrekqms", "dnaaehrekqms"}, {"cuewcvuy", "dnaaehrekqms"}, {"rpesfkhfjucj", "xpmxtfyvjrnujyxjh"}, {"wlvmfxbleuot", "bfufqsusp"}, {"xpmxtfyvjrnujyxjh", "mzfpofjn"}, {"rpesfkhfjucj", "rpesfkhfjucj"}, {"mzfpofjn", "rpesfkhfjucj"}, {"xpmxtfyvjrnujyxjh", "rpesfkhfjucj"}, {"bfufqsusp", "bfufqsusp"}, {"wlvmfxbleuot", "bfufqsusp"}, {"lkopigreodypvude", "lkopigreodypvude"}, {"hjogoueazw", "hjogoueazw"}, {"qvwvgzxqihvk", "qvwvgzxqihvk"}, {"mzvbgcizeeth", "mzvbgcizeeth"}, {"mzvbgcizeeth", "arigdtezmyz"}, {"arigdtezmyz", "arigdtezmyz"}, {"qvwvgzxqihvk", "arigdtezmyz"}, {"mzvbgcizeeth", "arigdtezmyz"}, {"lkopigreodypvude", "lkopigreodypvude"}, {"hjogoueazw", "lkopigreodypvude"}, {"tglnshmqlmkqqfbpf", "tglnshmqlmkqqfbpf"}, {"bbchthovla", "bbchthovla"}, {"rvihrzzkt", "tglnshmqlmkqqfbpf"}, {"tglnshmqlmkqqfbpf", "tglnshmqlmkqqfbpf"}, {"rvihrzzkt", "tglnshmqlmkqqfbpf"}, {"bbchthovla", "bbchthovla"}, {"filnwifbukdqijgr", "pkirimjwvyxs"}, {"gdziaihbagl", "gdziaihbagl"}, {"hlcsiukaroscfg", "hlcsiukaroscfg"}, {"gdziaihbagl", "orileazg"}, {"orileazg", "orileazg"}, {"gdziaihbagl", "orileazg"}, {"hlcsiukaroscfg", "orileazg"}, {"pkirimjwvyxs", "pkirimjwvyxs"}, {"filnwifbukdqijgr", "pkirimjwvyxs"}, {"xrgfejybbkezgor", "wtjtdrlm"}, {"yltljjairlkrmdq", "fllqjtnxwmfoou"}, {"wtjtdrlm", "wtjtdrlm"}, {"xrgfejybbkezgor", "wtjtdrlm"}, {"fllqjtnxwmfoou", "fllqjtnxwmfoou"}, {"yltljjairlkrmdq", "fllqjtnxwmfoou"}, {"ecqfdkebnamkfglk", "gwkkpxuvgp"}, {"inuzvkgolupxelcal", "inuzvkgolupxelcal"}, {"hgxrhkanzvzmsjpzl", "gwkkpxuvgp"}, {"cjjkmybleu", "cjjkmybleu"}, {"yzxogkunvohdmro", "yzxogkunvohdmro"}, {"inuzvkgolupxelcal", "yzxogkunvohdmro"}, {"yzxogkunvohdmro", "yzxogkunvohdmro"}, {"cjjkmybleu", "yzxogkunvohdmro"}, {"ecqfdkebnamkfglk", "ecqfdkebnamkfglk"}, {"gwkkpxuvgp", "ecqfdkebnamkfglk"}, {"hgxrhkanzvzmsjpzl", "ecqfdkebnamkfglk"}, {"qnjidlmwmxxjgntez", "hhrllhedyy"}, {"vyrvelteblnqaabc", "qnjidlmwmxxjgntez"}, {"wzflhbbgtc", "wzflhbbgtc"}, {"rnlryins", "rnlryins"}, {"fquzrlhdsnuwhhu", "zzdvolqtndzfjvqqr"}, {"zzdvolqtndzfjvqqr", "bvxiilsnsarhsyl"}, {"qnjidlmwmxxjgntez", "vyrvelteblnqaabc"}, {"vyrvelteblnqaabc", "vyrvelteblnqaabc"}, {"hhrllhedyy", "vyrvelteblnqaabc"}, {"rnlryins", "vyrvelteblnqaabc"}, {"fquzrlhdsnuwhhu", "zzdvolqtndzfjvqqr"}, {"zzdvolqtndzfjvqqr", "zzdvolqtndzfjvqqr"}, {"bvxiilsnsarhsyl", "zzdvolqtndzfjvqqr"}, {"wzflhbbgtc", "zzdvolqtndzfjvqqr"}, {"wgcjlntupylayse", "wgcjlntupylayse"}, {"hgtyntdmrgjh", "hgtyntdmrgjh"}, {"cemnayjhlnj", "cemnayjhlnj"}, {"wgcjlntupylayse", "wgcjlntupylayse"}, {"hgtyntdmrgjh", "wgcjlntupylayse"}, {"cemnayjhlnj", "cemnayjhlnj"}, {"aeloeauxmc", "aeloeauxmc"}, {"zwwgloilddclufwze", "aeloeauxmc"}, {"dkhfozltuckwog", "dwojnswr"}, {"dkhfozltuckwog", "dkhfozltuckwog"}, {"dwojnswr", "dkhfozltuckwog"}, {"aeloeauxmc", "aeloeauxmc"}, {"zwwgloilddclufwze", "aeloeauxmc"}, {"aotjpvanljxe", "aotjpvanljxe"}, {"stkglpqdjzxmnlito", "aotjpvanljxe"}, {"zfmpxgrevxp", "aotjpvanljxe"}, {"evepphnzuw", "evepphnzuw"}, {"rthpxoxyyiy", "pyzcbpjhntpefbq"}, {"aotjpvanljxe", "stkglpqdjzxmnlito"}, {"stkglpqdjzxmnlito", "stkglpqdjzxmnlito"}, {"zfmpxgrevxp", "stkglpqdjzxmnlito"}, {"rthpxoxyyiy", "rthpxoxyyiy"}, {"evepphnzuw", "rthpxoxyyiy"}, {"pyzcbpjhntpefbq", "rthpxoxyyiy"}, {"czlgbqzffodsoxng", "czlgbqzffodsoxng"}, {"gkqrglav", "gkqrglav"}, {"gkqrglav", "gkqrglav"}, {"czlgbqzffodsoxng", "czlgbqzffodsoxng"}, {"tyxrlpmcy", "tyxrlpmcy"}, {"livgsrfvgtovcurzq", "livgsrfvgtovcurzq"}, {"tyxrlpmcy", "tyxrlpmcy"}, {"livgsrfvgtovcurzq", "livgsrfvgtovcurzq"}, {"cufxsgbpjgqvk", "cufxsgbpjgqvk"}, {"cufxsgbpjgqvk", "inhzsspqltvl"}, {"shsgrqol", "shsgrqol"}, {"mnrdscqkycodx", "mnrdscqkycodx"}, {"inhzsspqltvl", "inhzsspqltvl"}, {"cufxsgbpjgqvk", "inhzsspqltvl"}, {"shsgrqol", "shsgrqol"}, {"mnrdscqkycodx", "shsgrqol"}, {"rphnhtvnihyfkrgv", "rphnhtvnihyfkrgv"}, {"edurtetzseifez", "edurtetzseifez"}, {"yykdqtkkdacpbwtbq", "yykdqtkkdacpbwtbq"}, {"rphnhtvnihyfkrgv", "rphnhtvnihyfkrgv"}, {"edurtetzseifez", "rphnhtvnihyfkrgv"}, {"yykdqtkkdacpbwtbq", "yykdqtkkdacpbwtbq"}, {"dhmiuqhqlsprxy", "dhmiuqhqlsprxy"}, {"ztisufueqzequ", "ztisufueqzequ"}, {"narvuaqmmkqhd", "narvuaqmmkqhd"}, {"narvuaqmmkqhd", "narvuaqmmkqhd"}, {"ztisufueqzequ", "narvuaqmmkqhd"}, {"dhmiuqhqlsprxy", "dhmiuqhqlsprxy"}, {"wmpvjvzljhnaxvp", "wmpvjvzljhnaxvp"}, {"ibwfxvxswjbecab", "ibwfxvxswjbecab"}, {"xydwvemqvtgvzl", "wmpvjvzljhnaxvp"}, {"wmpvjvzljhnaxvp", "wmpvjvzljhnaxvp"}, {"xydwvemqvtgvzl", "wmpvjvzljhnaxvp"}, {"ibwfxvxswjbecab", "ibwfxvxswjbecab"}, {"mkmawbogphdttd", "mkmawbogphdttd"}, {"bubwouozgs", "mkmawbogphdttd"}, {"ainlwrwabqcwq", "ainlwrwabqcwq"}, {"mkmawbogphdttd", "mkmawbogphdttd"}, {"bubwouozgs", "mkmawbogphdttd"}, {"ainlwrwabqcwq", "ainlwrwabqcwq"}, {"uzlxmaoro", "bfxbncez"}, {"qyaxqaqxiwr", "qyaxqaqxiwr"}, {"pdxsxjop", "pdxsxjop"}, {"pdxsxjop", "pdxsxjop"}, {"qyaxqaqxiwr", "pdxsxjop"}, {"bfxbncez", "bfxbncez"}, {"uzlxmaoro", "bfxbncez"}, {"subzoyxjkfiwmfb", "subzoyxjkfiwmfb"}, {"ooyllkxg", "ooyllkxg"}, {"subzoyxjkfiwmfb", "khcyhttaaxp"}, {"subzoyxjkfiwmfb", "subzoyxjkfiwmfb"}, {"khcyhttaaxp", "subzoyxjkfiwmfb"}, {"ooyllkxg", "ooyllkxg"}, {"orlzzpytpzazxr", "orlzzpytpzazxr"}, {"oufzmjgplt", "oufzmjgplt"}, {"wrszraxxdum", "wrszraxxdum"}, {"shfzcyboj", "shfzcyboj"}, {"oufzmjgplt", "oufzmjgplt"}, {"orlzzpytpzazxr", "oufzmjgplt"}, {"wrszraxxdum", "wrszraxxdum"}, {"shfzcyboj", "wrszraxxdum"}, {"yutahdply", "xozoyaqxtbustrymo"}, {"umlzibkkpsyvpdol", "pzlmeboecybxmetz"}, {"hqpnoczciajvkbdy", "rztcppnmud"}, {"llrzqdnoxbscnkqy", "jrocadcojmybpxmuj"}, {"cuewcvuy", "jzquemjzpvfbka"}, {"rpesfkhfjucj", "wlvmfxbleuot"}, {"lkopigreodypvude", "mzvbgcizeeth"}, {"tglnshmqlmkqqfbpf", "bbchthovla"}, {"orileazg", "filnwifbukdqijgr"}, {"yltljjairlkrmdq", "xrgfejybbkezgor"}, {"inuzvkgolupxelcal", "hgxrhkanzvzmsjpzl"}, {"hhrllhedyy", "wzflhbbgtc"}, {"cemnayjhlnj", "hgtyntdmrgjh"}, {"dkhfozltuckwog", "zwwgloilddclufwze"}, {"zfmpxgrevxp", "pyzcbpjhntpefbq"}, {"gkqrglav", "czlgbqzffodsoxng"}, {"tyxrlpmcy", "livgsrfvgtovcurzq"}, {"shsgrqol", "cufxsgbpjgqvk"}, {"rphnhtvnihyfkrgv", "yykdqtkkdacpbwtbq"}, {"dhmiuqhqlsprxy", "ztisufueqzequ"}, {"ibwfxvxswjbecab", "xydwvemqvtgvzl"}, {"mkmawbogphdttd", "ainlwrwabqcwq"}, {"pdxsxjop", "uzlxmaoro"}, {"ooyllkxg", "khcyhttaaxp"}, {"shfzcyboj", "orlzzpytpzazxr"}};


        List<List<String>> list = new ArrayList<>();
        for (String[] array : array3) {
            list.add(Arrays.asList(array));
        }

        System.out.println(demo.areSentencesSimilarTwo(array1, array2, list));
    }

    private final Map<String, String> map = new HashMap<>();


    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        for (List<String> similarPair : similarPairs) {
            map.put(similarPair.get(0), similarPair.get(0));
            map.put(similarPair.get(1), similarPair.get(1));
        }
        for (List<String> similarPair : similarPairs) {
            add(similarPair.get(0), similarPair.get(1));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (!checkSimilar(sentence1[i], sentence2[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSimilar(String word1, String word2) {
        if (word1.equals(word2)) {
            return true;
        }
        String root1 = find(word1);
        String root2 = find(word2);
        if (Objects.equals(root1, root2) && root1 != null) {
            return true;
        }
        return false;
    }


    private String find(String word) {
        String nextWord = map.get(word);
        if (!Objects.equals(word, nextWord) && nextWord != null) {
            // 这里有两种写法：
            // 1. 不return，赋值和递归。坏处是:有可能会形成环;好处是:时间快。
            // 2. 直接 return。坏处是：时间慢；好处是：不会形成环。
            // 一般经验告诉我们：优先使用不 return的方法。如果有环的话，可以通过整数数组来代替map.
//            map.put(word, find(nextWord));
            return find(nextWord);
        }
        return nextWord;
    }

    private void add(String word1, String word2) {
        String root1 = find(word1);
        String root2 = find(word2);
        if (Objects.equals(root1, root2)) {
            return;
        }
        map.put(root2, root1);
    }
}