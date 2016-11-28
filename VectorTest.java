import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*************************************************************************
> File Name: VectorTest.Java
> Author: crrinko
> Mail: crimson_rin@yeah.net
> Created Time: 2016/11/28 10:36
************************************************************************/

public class VectorTest {

	private List<Vector> vectors=new ArrayList<Vector>();
	private final int DIMEN=3;
	
	private double[] vec1={1,2,3};
	private double[] vec2={2,3,4};
	private double[] vec3={3,4,5};
 	
	@Before
	public void setUp() throws Exception {
		vectors.add(new Vector(Arrays.asList(vec1))); //测试向量1: (1,2,3)
		vectors.add(new Vector(Arrays.asList(vec2))); //测试向量2: (2,3,4)
		vectors.add(new Vector(Arrays.asList(vec3))); //测试向量3: (3,4,5)
	}

	@After
	public void tearDown() throws Exception {
	}

	private double getCos(double[] vecA, double[] vecB){
		double res=(vecA[0]*vecB[0]+vecA[1]*vecB[1]+vecA[2]*vecB[2])/
				(Math.sqrt(vecA[0]*vecA[0]+vecA[1]*vecA[1]+vecA[2]*vecA[2])
						*Math.sqrt(vecB[0]*vecB[0]+vecB[1]*vecB[1]+vecB[2]*vecB[2]));
		return res;
	}
	
	@Test
	public void testSimilary() {
		Vector reference=vectors.get(0); //取测试向量1作为测试元素
		double[] exceptedResult={getCos(vec1,vec2),getCos(vec1,vec2),getCos(vec1,vec3)};
		for(Vector test:vectors){
			double result=reference.similary(test);
			int index=vectors.indexOf(test);
			assertEquals(result,exceptedResult[index]);
		}
	}

}
