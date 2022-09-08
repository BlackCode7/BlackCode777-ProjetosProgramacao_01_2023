package planilha.excel.apache.EstudoAlgoritmos;

public class RangeSumQueryUsingSparseTable {

	/*Temos uma série de arr[]. Precisamos encontrar a soma de todos os elementos 
	 *na faixa L e R onde 0 <= L <= R <= n-1. Considere uma situação em que há 
	 *muitas consultas de faixa. 
	 */
	
	class GFG{

		int k = 16;
		int N = 100000;
		long table[][] = new long[N][k + 1];
		
		void buildSparseTable( int arr[], int n ) {
			for ( int i=0; i<n; i++ ) {
				table[i][0] = arr[i];
			}
			for( int j=0; j<=k; j++ ) {
				for( int i=0; i <= n-( 1 << j ); i++ ) {
					table[i][j] = table[i][j - 1] + table[i + (1 << ( j-1 ))][j-1];
				}
			}
		}
		
		long query( int L, int R ){
			long answer = 0;
			for( int j=k; j>=0; j-- ) {
				if( L+(1<<j)-1 <= R ) {
					answer = answer+table[L][j];
					L += 1 << j;
				}
			}
			return answer;
		}		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = { 3, 7, 2, 5, 8, 9 };
	    int n = arr.length;

	    int[] saa = arr;
		System.out.print(saa.length);
	}


}
