package co.id.bbw.myapplication.model_dummy;

import java.util.ArrayList;
import java.util.List;

import co.id.bbw.myapplication.R;

public class CreateDummyContent {

    public static List<DummyDm> createDummyDm() {
        List<DummyDm> dummyDms = new ArrayList<>();

        DummyDm dummyDm1 = new DummyDm();
        dummyDm1.setImg(R.drawable.monique);
        dummyDm1.setName("Monique Rodriguez");
        dummyDm1.setMessage("Hello");
        dummyDm1.setDay("1d");
        dummyDms.add(dummyDm1);

        DummyDm dummyDm2 = new DummyDm();
        dummyDm2.setImg(R.drawable.angel);
        dummyDm2.setName("Angel Lenka");
        dummyDm2.setMessage("Thx");
        dummyDm2.setDay("2d");
        dummyDms.add(dummyDm2);

        DummyDm dummyDm3 = new DummyDm();
        dummyDm3.setImg(R.drawable.andrew);
        dummyDm3.setName("Marcus Mor");
        dummyDm3.setMessage("What's up broo");
        dummyDm3.setDay("3d");
        dummyDms.add(dummyDm3);




        return dummyDms;
    }

    public static List<DummySearchHistory> createDummySearchHistory() {
        List<DummySearchHistory> dummySearchHistories = new ArrayList<>();

        DummySearchHistory dummySearchHistory1 = new DummySearchHistory();
        dummySearchHistory1.setFoto(R.drawable.andrew);
        dummySearchHistory1.setNama("Andrew");
        dummySearchHistories.add(dummySearchHistory1);

        DummySearchHistory dummySearchHistory2 = new DummySearchHistory();
        dummySearchHistory2.setFoto(R.drawable.monique);
        dummySearchHistory2.setNama("Monique");
        dummySearchHistories.add(dummySearchHistory2);

        DummySearchHistory dummySearchHistory3 = new DummySearchHistory();
        dummySearchHistory3.setFoto(R.drawable.angel);
        dummySearchHistory3.setNama("Angel");
        dummySearchHistories.add(dummySearchHistory3);

        return dummySearchHistories;


    }
}
