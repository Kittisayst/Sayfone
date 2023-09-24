package Utility;

public class AbsentCaculator {

    private int ComeCount = 0;
    private int SickCount = 0;
    private int AbsentCount = 0;

    public AbsentCaculator(String jsonText) {
        JoJson json = new JoJson(jsonText);
        json.getJsonAll().forEachRemaining((data) -> {
            Caculator(data.getValue().asInt());
        });
    }

    private void Caculator(int State) {
        switch (State) {
            case 0:
                ComeCount += 1;
                break;
            case 1:
                SickCount += 1;
                break;
            case 2:
                AbsentCount += 1;
                break;
            default:
                break;
        }
    }

    public int getComeCount() {
        return ComeCount;
    }

    public int getSickCount() {
        return SickCount;
    }

    public int getAbsentCount() {
        return AbsentCount;
    }
    
    
}
