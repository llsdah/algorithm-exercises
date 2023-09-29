public class LRU {

	public static void main(String[] args) {

	}
	
	
	
	// LRU
	public class CacheItem {
		int key;
		int value;
		CacheItem prev;
		CacheItem next;

		public CacheItem(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	CacheItem head;
	CacheItem tail;
	int capacity;
	Map<Integer,CacheItem> map;
	
	public void LRUCache(int capatity) {
		head=null;
	}
	
	
	
	public int get(int key) {
		
		if( !map.containsKey(key)) {
			return -1;
		}else {
			CacheItem cur = map.get(key);
		
			if( cur !=head ) {
				if(cur == tail) {
					// move tail to one in front 
					tail = tail.prev;
				}
				//head ... cur.prev - cur -cur.next				
				// move cur to head
				
				if( cur.prev != null) {
					cur.prev.next = cur.next;
				}
				if( cur.next != null) {
					cur.next.prev = cur.prev;
				}
				cur.next =head;
				cur.prev = cur;
				cur.prev =null;
				head = cur;
			}
			return cur.value;
		}
		
	}
	
	public void put(int key, int value) {
		// 없다면
		if( get(key)==-1) {
			//insert
			CacheItem cur = new CacheItem(key,value);
			
			if( head ==null) {
				head =cur;
				tail = cur;
						
			}else {
				cur.next =head;
				head.prev =cur;
				head = cur;
			}
			
			map.put(key,cur);
			if( map.size()>capacity) {
				// teil remove;
				map.remove(tail.key);
				tail.prev.next = null;
				tail = tail.prev;
				
			}
			
			
		}else {
			//update
			map.get(key).value = value;
		
		}

		
		
		
	}

}







