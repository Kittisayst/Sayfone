package DAOSevervice;

import Model.SayfoneModel;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParentJobService {

    public List<String> getJobs() {
        SayfoneModel model = new SayfoneService().getById(3);
        String str = model.getEnglish();
        String[] array = str.substring(1, str.length() - 1).split(", ");
        List<String> result = Arrays.stream(array)
                .map(s -> s.replaceAll("\"", ""))
                .collect(Collectors.toList());
        return result;
    }
    
    public void update(String text){
          new SayfoneService().updateParentJob(text);
    }
    
}
