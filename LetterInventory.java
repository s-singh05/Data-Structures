
class LetterInventory {
    private int sum;
    private int[] inventory;
   

    public LetterInventory(String data){
        data = data.toLowerCase();
        inventory = new int[26];
        sum = data.length();
        char chArr[] = data.toCharArray();

        int asciiVal = 0;
        for(int i = 0; i < chArr.length; i++){
            asciiVal = (int)chArr[i];
            if(asciiVal<97 || asciiVal>122){
               sum--;
            }
            else{
               //asciiVal = (int)chArr[i];
               asciiVal -= 97;
               inventory[asciiVal] += 1; 
            }
        }
    }

    public int size(){
        return sum;
    }

    public boolean isEmpty(){
        return sum == 0;
    }

    public int get(char letter){
        letter = Character.toLowerCase(letter);
        if((int)letter < 97 || (int)letter > 122){
            throw new IllegalArgumentException("no");
        }
        int asciiVal = (int)letter - 97;
        return(inventory[asciiVal]);
    }

    public String toString(){
        int value;
        char asciiVal;
        String finalString = "[";
        for(int i = 0; i < 26; i++){
            value = inventory[i];
            asciiVal = (char)(i+97);
            for(int j = 0; j < value; j++){
                finalString += asciiVal;
            }
        }

        finalString += "]";

        return finalString;
    }

    public void set(char letter, int value){
        letter = Character.toLowerCase(letter);
        if((int)letter < 97 || (int)letter > 122){
            throw new IllegalArgumentException("no");
        }
  
        sum -= inventory[(int)letter-97];
        inventory[(int)letter-97] = value;
        sum += value;
        
    }
    
    public LetterInventory add(LetterInventory other){
        String newVal = this.toString() + other.toString();
        LetterInventory returnThis = new LetterInventory(newVal);
        return returnThis;
    }

    public LetterInventory subtract(LetterInventory other){
        LetterInventory returnThis = new LetterInventory("");
        for(int i = 0; i < 26; i++){
            returnThis.inventory[i] = this.inventory[i] - other.inventory[i];
            if(returnThis.inventory[i] < 0){
                return null;
            }
        }
        String val = returnThis.toString();
        LetterInventory returnThis2 = new LetterInventory(val);
        return returnThis2;
    }




}
