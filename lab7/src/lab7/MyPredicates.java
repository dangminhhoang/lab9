package lab7;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while(iter.hasNext()) {
			T next = iter.next();
			if(p.test(next))
				iter.remove();
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T obj = iterator.next();
            if (!p.test(obj)) {
                iterator.remove();
            }
        }
    
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	// Phương thức để chọn các đối tượng từ coll mà thỏa mãn điều kiện của Predicate p
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> result = new HashSet<>();
        for (T obj : coll) {
            if (p.test(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	// Phương thức để tìm index của phần tử đầu tiên thỏa mãn điều kiện của Predicate p
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		 int index = 0;
	        for (T obj : coll) {
	            if (p.test(obj)) {
	                return index;
	            }
	            index++;
	        }
	        return -1; // Không tìm thấy phần tử thỏa mãn điều kiện
	    }
}