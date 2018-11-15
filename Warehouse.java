import javax.swing.*;
public class Trabalho1 {
	public static void main(String args[]) {
		int i, j;
		String armazem[][] = new String[3][4];
		for (i=1;i<=3;i++){
			for(j=1;j<=4;j++){
				armazem[i-1][j-1] = i+"00"+j;
			}
		}

		//1) Solicite ao usuário a quantidade de caixas de cerveja em cada compartimento, a mensagem que aparece para o usuário deve seguir EXATAMENTE o seguinte modelo:
		int BeerBox[][] = new int[3][4];
		for (i=0;i<3 ;i++) {
			for (j=0;j<4 ;j++) {
				BeerBox[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Olá, insira a quantidade de caixas de cerveja para o compartimento "+ armazem[i][j] + ": "));
			}
		}
		//2) Qual é o número total de caixas de cerveja no armazém ?
		int somaCaixas = 0;
		for (i=0;i<3 ;i++) {
			for (j=0;j<4 ;j++) {
				somaCaixas = somaCaixas + BeerBox[i][j];
			}
		}
		JOptionPane.showMessageDialog(null, "A quantidadede total de caixas de cerveja no armazém é: " + somaCaixas);

		//3) O armazém está desorganizado, calcule o número ideal de caixas de cerveja que deveriam estar alocados em cada compartimento. (Calcule a média).
		int mediaCaixas = somaCaixas / 12;
		JOptionPane.showMessageDialog(null, "A quantidadede de caixas de cerveja que deveriam estar em cada compartimento é: " + mediaCaixas);

		//4) Qual é o número do compartimento que MAIS tem caixas de cerveja ?
		int maisCaixasI = 0;
		int maisCaixasJ = 0;
		int maisCaixas = 0;
		for (i=0;i<3 ;i++) {
			for (j=0;j<4 ;j++) {
				if(BeerBox[i][j]> maisCaixas){
					maisCaixas = BeerBox[i][j];
					maisCaixasI = i;
					maisCaixasJ = j;
				}
			}
		}
		JOptionPane.showMessageDialog(null,"O compartimento com mais caixas é o de numero: "+ armazem[maisCaixasI][maisCaixasJ]);

		//5) Qual é o número do compartimento que MENOS tem caixas de cerveja ?
		int menosCaixasI = 0;
		int menosCaixasJ = 0;
		int LessBox = 999999999;
		for (i=0;i<3 ;i++) {
			for (j=0;j<4 ;j++) {
				if(BeerBox[i][j]< LessBox){
					LessBox = BeerBox[i][j];
					menosCaixasI = i;
					menosCaixasJ = j;
				}
			}
		}
		JOptionPane.showMessageDialog(null,"O compartimento com menos caixas é o de numero: "+ armazem[menosCaixasI][menosCaixasJ]);

		//6) Peça que o usuário informe o número de um dos compartimentos(exemplo 1003), diga quantas caixas de cerveja tem neste compartimento. 
		String CompC = JOptionPane.showInputDialog("Informe o número de um dos compartimentos para saber a quantidade de cervejas.");
		char n1 = CompC.charAt(0);
		char n2 = CompC.charAt(3);
		JOptionPane.showMessageDialog(null,"A quantidade de caixas no compartimento "+ CompC +" é de: "+ BeerBox[n1-49][n2-49]);

		//7) Mostre todas as quantidades de caixas de cerveja ordenadas em apenas 1 mensagem. Para isso coloque todas as quantidades em um vetor e ordene com o BubbleSort.
		int Allboxes[] = new int[12];
		int x = 0;
		int BeerFlag = 1;
		int BeerAux = 0;
		String AmountBeer = "";
		for (i=0;i<3 ;i++) {
			for (j=0;j<4 ;j++ ) {
				Allboxes[x] = BeerBox[i][j];
				x++;
			}
		}
		while(BeerFlag == 1){
			BeerFlag = 0;
			for (i=0;i<11 ;i++) {
				if (Allboxes[i]> Allboxes[i+1]) {
					BeerAux = Allboxes[i];
					Allboxes[i] = Allboxes[i +1];
					Allboxes[i+1] = BeerAux;
					BeerFlag = 1;
				}
			}
		}
		for (i=0;i<12 ;i++ ) {
			AmountBeer = AmountBeer + " : " + Allboxes[i] +" : ";
		}
		JOptionPane.showMessageDialog(null,"A quantidade de cerveja no armazem em ordem é " + AmountBeer);

		//8) Mostre a porcentagem do número de compartimentos em relação ao total (12 compartimentos), que possuem mais caixas de cerveja que a média do armazém.
		int K= 0;
		Double Porcnt;
		for (i=0;i<3 ;i++) {
			for (j=0;j<4 ;j++) {
				if (BeerBox[i][j]> mediaCaixas) {
					K++;
				}
			}
		}
		Porcnt = ((K*100) /12.00);
		JOptionPane.showMessageDialog(null,"Há "+Porcnt+"% de compartimentos com mais caixas que a média.");

		//9) Mostre o número do compartimento que MENOS tem caixas de cerveja na Prateleira 2
		String Less2 = "";
		int Prateleira2 = 9999999;
		int PrI = 0;
		for (i=0;i<4 ;i++ ) {
			if (BeerBox[1][i]< Prateleira2) {
				Prateleira2 = BeerBox[1][i];
				PrI = i + 1;
			}
		}
		Less2 = "200"+PrI;
		JOptionPane.showMessageDialog(null,"O compartimento com menos caixas na prateleira 2 é o: " + Less2 );

		//10) Mostre o número do compartimento que MAIS tem caixas de cerveja na Prateleira 3.
		int Prateleira3 = 0;	
		int PrK= 0;
		String More3 = "";
		for (i=0;i<4 ;i++ ) {
			if (BeerBox[2][i]> Prateleira3) {
				Prateleira3 = BeerBox[2][i];
				PrK = i;
			}
		}
		More3 = armazem[2][PrK];
		JOptionPane.showMessageDialog(null,"O compartimento com mais caixas de cerveja na prateleira 3 é o: " + More3);
	}
}