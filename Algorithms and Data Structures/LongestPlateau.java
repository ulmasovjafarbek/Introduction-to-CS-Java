/**PORBLEM DESCRIPTION: Given an array of integers int A[], find the length and location of the longestcontiguous sequence of equal values for which the values of the elements just before and just after this sequence is smaller. You should just print thes two numbers (first is the length and second is thestarting index of plateau).
 * 
 * EXAMPLE:
 * Input: java LongestPlateau 1 2 2 2 2 1
 * Output: 
 * 		4
 * 		1
 * Input: java LongestPlateau 3 2 2 2 1 2 1 1 1 2 2 0 1 1 1 1 0
 * Output:
 * 		4
 * 		12
 */

public class LongestPlateau
{
	private static int[] parseInputArray(String[] args) {
		int[] value = new int[args.length+1];
		for(int i = 0 ; i < args.length; i++){
			if (i == args.length-1) value[i] = 0;
			value[i] = Integer.parseInt(args[i]);}
		return value;
	}
	public static void printLargestPlateau(int[] values) {
		int biggestStartIndex = -1;
		int biggestLenth = 0;
		int currentIndex = 1;
		int currentPlateauStartIndex = 1;
		int currentLenght = 1;
		boolean plateauStarted = false;
		while (currentIndex < values.length) {
			if(isStartOfPlateau(currentIndex, values)){
				plateauStarted = true;
				currentLenght = 1;
				currentPlateauStartIndex = currentIndex;
			} else if (isEndOfPlateau(currentIndex, values)) {
				if(plateauStarted && currentLenght > biggestLenth){
					biggestLenth = currentLenght;
					biggestStartIndex = currentPlateauStartIndex;}
				plateauStarted = false;
				currentLenght = 1;
			} else { currentLenght++; }
			currentIndex++;
		}
		System.out.println(biggestLenth +"\n"+biggestStartIndex);
	}
	private static boolean isStartOfPlateau(int index, int[] values){
		if(index <= 0){ return false; }
		return values[index-1] < values[index];}
	private static boolean isEndOfPlateau(int index, int[] values){
		if(index <= 0){ return false; }
		return values[index - 1] > values[index];}

   
    public static void main(String[] args)
    {
		int[] values = parseInputArray(args);
		printLargestPlateau(values);
    }
}
