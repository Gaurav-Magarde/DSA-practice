class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        boolean[] isGood = new boolean[n];
        int curr = 0;
        for(int i = 0;i<n;i++){
            if(i>0 && nums[i]<=nums[i-1]) curr++;
            else curr = 0;

            if(i+1 <n && curr>=k-1) isGood[i+1] = true;
        }
        curr = 0;
        isGood[n-1] = false;
        for(int i = n-1;i>=0;i--){
            if(i<n-1 &&  nums[i]<=nums[i+1]) curr++;
            else curr = 0;

            if(i>0 && curr<k-1) isGood[i-1] = false;
        }

        List<Integer> ans = new ArrayList();
        for(int i = 0;i<n;i++){
            if(isGood[i]) ans.add(i);
        }
        return ans;
    }
}