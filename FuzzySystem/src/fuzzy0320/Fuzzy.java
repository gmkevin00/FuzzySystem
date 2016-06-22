package fuzzy0320;

public class Fuzzy {
	double frontLen;
	double sideLen;
	
	double frontSmall=0;
	double frontLarge=0;
	double sideLeftSmall=0;
	double sideLeftLarge=0;
	double sideRightSmall=0;
	double sideRightLarge=0;
	
	
	
	double[] alpha;
	double[] rule;
	
	double ans=0;

	public double detectValue(double frontLen, double sideLen) {
		alpha=new double[8];
		rule=new double[8];
		
		frontSmall=0;
		frontLarge=0;
		sideLeftSmall=0;
		sideLeftLarge=0;
		sideRightSmall=0;
		sideRightLarge=0;
		
		ans=0;
		
		// TODO Auto-generated method stub
		this.frontLen=frontLen;
		this.sideLen=sideLen;
		
		valueToFuzzy();
		fuzzyToRule();
		ruleToAns();
		
		
		return ans;
	}


	private void valueToFuzzy() {
		// TODO Auto-generated method stub
		if(frontLen<=50){
			frontSmall=1;
		}
		else if(frontLen>50&&frontLen<=200){
			frontSmall=(frontLen*(-1)+200)/150;
		}
		
		if(frontLen>200){
			frontLarge=1;
		}
		
		
		
		if(sideLen>=-10&&sideLen<=0){
			sideLeftSmall=1;
		}
		else if(sideLen<-10&&sideLen>-50){
			sideLeftSmall=(sideLen+50)/40;
		}
		
		if(sideLen<-50){
			sideLeftLarge=1;
		}
		
		
		if(sideLen<=10&&sideLen>0){
			sideRightSmall=1;
		}
		else if(sideLen>10&&sideLen<=50){
			sideRightSmall=(sideLen-50)/-40;
		}
		
		if(sideLen>50){
			sideRightLarge=1;
		}
		
	}
	
	private void fuzzyToRule() {
		// TODO Auto-generated method stub
		alpha[0]=Math.abs(sideLeftLarge);
		rule[0]=-40*alpha[0];
		
		alpha[1]=Math.abs(sideRightLarge);
		rule[1]=40*alpha[1];
	
		alpha[2]=Math.abs(findMin(frontLarge,sideLeftSmall));
		rule[2]=-30*alpha[2];
		
		alpha[3]=Math.abs(findMin(frontLarge,sideRightSmall));
		rule[3]=30*alpha[3];
		
		alpha[4]=Math.abs(findMin(frontSmall,sideLeftSmall));
		rule[4]=-20*alpha[4];
		
		alpha[5]=Math.abs(findMin(frontSmall,sideRightSmall));
		rule[5]=20*alpha[5];
		
		

	}
	


	private void ruleToAns() {
		double alphaTotal=0;
		// TODO Auto-generated method stub
		for(int i=0;i<rule.length;i++){
			ans+=rule[i];
			alphaTotal+=alpha[i];
		}
		
		
		ans=ans/alphaTotal;
		if(ans<-40){
			ans=-40;
		}
		else if(ans>40){
			ans=40;
		}
	}
	
	
	public double findMin(double frontLarge2,double sideSmall2){
		if(frontLarge2>sideSmall2){
			return sideSmall2;
		}
		else{
			return frontLarge2;
		}
	}
	
	
}
