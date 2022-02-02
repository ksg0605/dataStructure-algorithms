package array;

public class PrintArray2 {
    String[] dataset = {
            "Braund, Mr. Owen Harris",
            "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
            "Heikkinen, Miss. Laina",
            "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
            "Allen, Mr. William Henry",
            "Moran, Mr. James",
            "McCarthy, Mr. Timothy J",
            "Palsson, Master. Gosta Leonard",
            "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
            "Nasser, Mrs. Nicholas (Adele Achem)",
            "Sandstrom, Miss. Marguerite Rut",
            "Bonnell, Miss. Elizabeth",
            "Saundercock, Mr. William Henry",
            "Andersson, Mr. Anders Johan",
            "Vestrom, Miss. Hulda Amanda Adolfina",
            "Hewlett, Mrs. (Mary D Kingcome) ",
            "Rice, Master. Eugene",
            "Williams, Mr. Charles Eugene",
            "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
            "Masselmani, Mrs. Fatima",
            "Fynney, Mr. Joseph J",
            "Beesley, Mr. Lawrence",
            "McGowan, Miss. Anna",
            "Sloper, Mr. William Thompson",
            "Palsson, Miss. Torborg Danira",
            "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
            "Emir, Mr. Farred Chehab",
            "Fortune, Mr. Charles Alexander",
            "Dwyer, Miss. Ellen",
            "Todoroff, Mr. Lalio"
    };

    public Integer countM() {
        Integer count = 0;

        for (Integer item=0; item < dataset.length; item++) {
            // <2021.06.14 업데이트>
            // 영상에서 indexOf("M") > 0 으로 설명드렸습니다만, "M" 부터 시작되는 문자열은 indexOf("M")  값이 0 이 나오므로,
            // >= 으로 자료 코드에서 수정하였습니다.
            if (dataset[item].indexOf("M") >= 0) {
                // System.out.println(dataset[item]);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PrintArray2 printArray2 = new PrintArray2();
        System.out.println(printArray2.countM());
    }
}
