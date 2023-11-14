package ro.ase.grupa1098;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProdusParser {
    private final static String ID = "id";
    private final static String DENUMIRE = "denumire";
    private final static String PRET = "pret";

    public static List<Produs> fromJson(String json) {
        try {
            JSONArray array = new JSONArray(json);
            return citireProduse(array);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    private static List<Produs> citireProduse(JSONArray array) throws JSONException {
        List<Produs> listaProduse = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Produs produs = citireProdus(array.getJSONObject(i));
            listaProduse.add(produs);
        }
        return listaProduse;
    }

    private static Produs citireProdus(JSONObject object) throws JSONException {
        String denumire = object.getString(DENUMIRE);
        long id = object.getLong(ID);
        float pret = (float) object.getDouble(PRET);

        return new Produs(id, denumire, pret);
    }
}
