package studyProgrammers;

import java.util.Arrays;

/*

섬 연결하기
문제 설명
n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 
최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 
필요한 최소 비용을 return 하도록 solution을 완성하세요.

다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 
예를 들어 A 섬과 B 섬 사이에 다리가 있고, 
B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.

제한사항

섬의 개수 n은 1 이상 100 이하입니다.
costs의 길이는 ((n-1) * n) / 2이하입니다.
임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는
다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 
이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.

같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 
즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 
이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
연결할 수 없는 섬은 주어지지 않습니다.


입출력 예
n			costs														return
4			[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]		4


입출력 예 설명

costs를 그림으로 표현하면 다음과 같으며, 이때 초록색 경로로 
연결하는 것이 가장 적은 비용으로 모두를 통행할 수 있도록 만드는 방법입니다.


*/
public class Greedy5 {
	public static void main(String[] args) {
		
	int n =4;
	int[][] costs = { {0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}  };
		
		solution(n,costs);
	}
	
	public static int solution(int n, int[][] costs) {
		int answer = 0;

		//섬번호
		int[] island = new int[n];
		
		for(int i=0;i<n;i++) {
			island[i]=i;
			
		}

		// 람다식 돌아가는거 주의 a[x][2]
		Arrays.sort(costs,(a,b)->Integer.compare(a[2],b[2]));
		System.out.println("Arrays.deepToString(costs)"+ Arrays.deepToString(costs));
		System.out.println("시작 island : "+ Arrays.toString(island));
		
		for(int i=0; i<costs.length;i++) {
			if( find(island,costs[i][0]) != find(island,costs[i][1]) ){
				union(island,costs[i][0],costs[i][1]);
				
				System.out.println("answer : "+answer);
				System.out.println();
				answer +=costs[i][2];
			}
		}
		
		System.out.println("최종 island : "+ Arrays.toString(island));
		
		return answer;
	}

	
	private static void union(int[] island, int i, int j) {
		// TODO Auto-generated method stub
	       int a = find(island, i);
	        int b = find(island, j);
	     
	        island[a] = b;
	        System.out.println("Union island : "+ Arrays.toString(island));
		
	}

	// 같은 섬 번호 인지 찾는법 
	private static int find(int[] island, int i) {
		System.out.println("Find island : "+ Arrays.toString(island));
		if(island[i]==i) {
			System.out.println("return i : "+i);
			return i;
		}
		
		return find(island,island[i]);
	}


}

/*
 * 

import java.util.Arrays;

class Solution
{
    public int solution(int n, int[][] costs)
    {
        int sum = 0;
        int[] island = new int[n];

        for(int i = 0; i < n; i++)
            island[i] = i;

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        for(int i = 0; i < costs.length; i++)
        {
            if(find(island, costs[i][0]) != find(island, costs[i][1]))
            {
                unite(island, costs[i][0], costs[i][1]);
                sum += costs[i][2];
            }
        }

        return sum;
    }

    private int find(int[] island, int x)
    {
        if(island[x]== x)
            return x;
        return find(island, island[x]);
    }

    private void unite(int[] island, int x, int y)
  
    {
        int a = find(island, x);
        int b = find(island, y);
        island[a] = b;
    }
}



*/
