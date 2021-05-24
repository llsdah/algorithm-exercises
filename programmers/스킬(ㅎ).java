class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] sk = skill.toCharArray();
        int leng = sk.length;
        for(int k=0; k<skill_trees.length;k++){
            char[] tree = skill_trees[k].toCharArray();
            int pos = 0;
            boolean[] check = new boolean[leng];    
            loof : for(int h=0; h<tree.length;h++){
                for(int i=0;i<leng;i++){
                    if(sk[i]==tree[h]){
                        for(int t =0; t<i;t++){
                            if(!check[t]) {
                                pos =1;
                                break loof;
                            }
                        }
                        check[i]=true;
                    }
                }

            }
            if(pos ==0){
                answer++;
            }

        }

        return answer;
    }
}
