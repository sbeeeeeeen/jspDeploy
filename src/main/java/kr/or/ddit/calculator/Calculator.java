package kr.or.ddit.calculator;

/**
* Calculator.java
*
* @author PC16
* @since 2018. 7. 6.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 7. 6. PC16 최초 생성
*
* </pre>
*/
public class Calculator {
	
	public static void main(String args[]){
		Calculator cal = new Calculator();
		int addResult = cal.add(5,6);
		
		if(addResult == 11){
			System.out.println("덧셈 결과가 올바릅니다");
		}else{
			System.out.println("덧셈 결과가 틀렸습니다");
		}
		
		////////////////////////////////////////////////////////////
		int minusResult = cal.minus(6, 4);
		if(minusResult == 2){
			System.out.println("뺄셈 결과가 올바릅니다");
		}else{
			System.out.println("뺄셈 결과가 틀렸습니다");
		}
		////////////////////////////////////////////////////////////
		//mul, div
		int mulResult = cal.mul(4, 2);
		if(mulResult == 8){
			System.out.println("곱셈 결과가 올바릅니다");
		}else{
			System.out.println("곱셈 결과가 틀렸습니다");
		}
		
		int divResult = cal.div(6, 2);
		if(divResult == 3){
			System.out.println("나눗셈 결과가 올바릅니다");
		}else{
			System.out.println("나눗셈 결과가 틀렸습니다");
		}
		
	}
	
	/**
	* Method : add
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC16
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 : 계산기의 덧셈 기능
	*/
	public int add(int param1, int param2){
		return param1+param2;
	}
	
	/**
	* Method : minus
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC16
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 : 계산기의 뺄셈 기능
	*/
	public int minus(int param1, int param2){
		return param1-param2;
	}
	
	/**
	* Method : mul
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC16
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 : 계산기의 곱셈 기능
	*/
	public int mul(int param1, int param2){
		return param1*param2;
	}
	
	/**
	* Method : div
	* 최초작성일 : 2018. 7. 6.
	* 작성자 : PC16
	* 변경이력 :
	* @param param1
	* @param param2
	* @return
	* Method 설명 : 계산기의 나눗셈 기능
	*/
	public int div(int param1, int param2){
		return param2==0?0:param1/param2;
	}
}
