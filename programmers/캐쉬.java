	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		

		if (cacheSize == 0) {
			return cities.length * 5;
		}

		
		
		boolean hit = false; // 존재 여부 체크
		LinkedList<String> que = new LinkedList<String>();
		
		for (int i = 0; i < cities.length; i++) {
			hit = que.contains(cities[i].toLowerCase());

			if (!hit) { //없다. 
				que.addFirst(cities[i].toLowerCase());
				answer+=5;
			} else {
				que.remove(cities[i].toLowerCase());
				que.addFirst(cities[i].toLowerCase());
				answer ++;
			}

			if( que.size()>cacheSize) {
				que.remove(que.size()-1);
			}
		}

		Iterator<String> it = que.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		return answer;
	}
