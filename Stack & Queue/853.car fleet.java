public int carFleet(int target, int[] pos, int[] speed) {

		int[][] carsInfo = new int[pos.length][2];
		for(int i=0;i<pos.length;i++){
			carsInfo[i][0] = pos[i];
			carsInfo[i][1] = speed[i];
		}
		Arrays.sort(carsInfo,(x,y)->y[0]-x[0]);
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<carsInfo.length;i++){
			if(stack.size()==0)
				stack.push(i);
			else{
				if(((float)(target-carsInfo[stack.peek()][0])/carsInfo[stack.peek()][1])<(float)(target-carsInfo[i][0])/carsInfo[i][1]){
					stack.push(i);
				}
			}
		}
		return stack.size();
	}
