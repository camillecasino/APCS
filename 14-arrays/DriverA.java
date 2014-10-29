import java.util.*;

public class DriverA {
    public static void main(String[] args) {
	public int find(int value) {
	    for (int i = 0; i < a.length; i++) {
		if (a[i] == value) {
		    return i;
		}
		return -1;
	    }
	}

	public int sum67(int[] nums) {
	    boolean hitSix = false;
	    int answer = 0;
	    for (int i = 0; i < nums.length; i++) {
		if (nums[i] == 7 && hitSix) {
		    hitSix = false; answer -= 7;
		}
		if (nums[i] == 6 && !hitSix) {
		    hitSix = true;
		}
		if (!hitSix){
		    answer += nums[i];
		}
	    }
	    return answer;
	}

	public boolean more14(int[] nums) {
	    int numones = 0;
	    int numfours = 0;
	    for (int i = 0; i < nums.length; i++){
		if (nums[i] == 1) {numones++;}
		if (nums[i] == 4) {numfours++;}
	    }
	    return (numones > numfours);
	}

	public int[] tenRun(int[] nums) {
	    int currTen = -1;
	    for (int i = 0; i < nums.length; i++){
		if (currTen == -1) {
		    if (nums[i] % 10 == 0) {
			currTen = nums[i];
		    }
		}
		else {
		    if (nums[i] % 10 == 0) {
			currTen = nums[i];
		    }
		    else {
			nums[i] = currTen;
		    }
		}
	    }
	    return nums;
	}





	

    }

}

