package oneper.domobj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProblemsList implements Serializable{

	List<Problem> proList;
	
	public void addProblem(Problem pro){
		
		if(null == proList ){
			proList = new ArrayList<Problem>();
		}
		proList.add(pro); 
	}
	
	public List<Problem> getProList() {
		return proList;
	}

	public void setProList(List<Problem> proList) {
		this.proList = proList;
	}
}
