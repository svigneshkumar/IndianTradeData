import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<CountryYearCompositeKey, Text, CountryYearCompositeKey, Text> {

    @Override
    protected void reduce(CountryYearCompositeKey key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        Text contextText = new Text();
        Iterator<Text> iterator = values.iterator();
        double importValue = 0.0;
        double exportValue = 0.0;

        while (iterator.hasNext()) {

            String token = iterator.next().toString();

            String[] datumSplit = token.trim().split(" ");
            String mode = datumSplit[0].trim();
            double commodityValue = Double.parseDouble(datumSplit[1].trim());

            if (mode.equals("import")) {
                importValue += commodityValue;

            } else {
                exportValue += commodityValue;
            }
        }

        String contextValue = " import " + importValue + " export " + exportValue;
        contextText.set(contextValue);
        context.write(key, contextText);
    }
}