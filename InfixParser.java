package hw2;

public class InfixParser 
{
	private String expr;
	private int cur;
	
	
	
	public boolean isExpression(String expr)
	{
		this.expr = expr;
		this.cur=0;
		
		boolean valid = isExpression();
		if(valid)
		{
			return this.cur == this.expr.length();
		}
		return false;
	}
	
	private boolean isExpression() {
		boolean valid = isTerm();
		
		if(valid && moreChars())
		{
			//cur++;
			if(this.expr.charAt(this.cur)=='+'|| this.expr.charAt(this.cur)=='-')
			{
				this.cur++;
				valid = isTerm();

			}
			
			
		}
		return valid;
		}
	
	private boolean isTerm()
	{
		boolean valid = isFactor();
		if(moreChars())
		{
			if(valid) 
			{
			
			if(this.expr.charAt(this.cur)=='*'|| this.expr.charAt(this.cur)=='/')
			{
				this.cur++;
				valid = isFactor();

			}
			
			}
			
		}
		return valid;
		
	
	}

	private boolean isFactor()
	{
		boolean valid = isLetter();
		//String length;
		
		
		
		if(valid)//valid = true
		{
			return true;
		}
		
		if(moreChars())
		{
			if(expr.charAt(this.cur)=='(')
			{
				cur++;
			
			 valid = isExpression();
			 if(moreChars())
			 {
				 if(valid)
				 {
					 if(this.expr.charAt(this.cur)==')')
					 {
						 this.cur++;
						 return true;
					 }
				 }
			 }
		}
		}
		return false;	
		
		
	}
	private boolean isLetter()
	{
		if (moreChars()) 
		{
			
		if(this.expr.charAt(this.cur)>='A' && this.expr.charAt(this.cur)<='Z')
		{
			this.cur++;
			return true;
		}
		
		}
		return false;	
	}
	
	private boolean moreChars()
	{
		return this.cur<this.expr.length();
	}

}
