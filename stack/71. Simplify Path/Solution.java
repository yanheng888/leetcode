import java.util.ArrayList;

class Solution {
    public String simplifyPath(String path) {
        ArrayList<String> arr1 = new ArrayList<>();
        int i = 0;
        while(i + 1 <path.length()){
            int j = path.indexOf("/", i+1);
            if(j == -1){
                arr1.add(path.substring(i+1));
                break;
            }else{
                arr1.add(path.substring(i+1,j));
            }
            i = j;
        }
        ArrayList<String> arr2 = new ArrayList<>();

        for(String s : arr1){
            if(".".equals(s) || "".equals(s)){
                continue;
            }else if("..".equals(s)){
                if(arr2.size() > 0){
                    arr2.remove(arr2.size() - 1);
                }
            }else{
                arr2.add(s);
            }
        }
        String ret = "";
        for(String s: arr2){
            ret += "/" + s;
        }
        return ret == "" ? "/" : ret;
    }//"/a/./b/../../c/" "/home"
}
