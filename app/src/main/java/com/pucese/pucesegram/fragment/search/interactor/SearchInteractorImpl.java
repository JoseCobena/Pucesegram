package com.pucese.pucesegram.fragment.search.interactor;

import com.pucese.pucesegram.adapter.PictureAdapterRecyclerView;
import com.pucese.pucesegram.fragment.search.presenter.SearchPresenter;
import com.pucese.pucesegram.model.Picture;

import java.util.ArrayList;

public class SearchInteractorImpl implements SearchInteractor{
    private SearchPresenter presenter;

    public SearchInteractorImpl(SearchPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void filtrar(String texto, PictureAdapterRecyclerView pictureAdapterRecyclerView, ArrayList<Picture> pictures) {
        ArrayList<Picture> filtrarLista = new ArrayList<>();

        for(Picture usuario : pictures) {
            if(usuario.getUsername().toLowerCase().contains(texto.toLowerCase())) {
                filtrarLista.add(usuario);
            }
        }

        pictureAdapterRecyclerView.filtrar(filtrarLista);
    }

    @Override
    public ArrayList<Picture> buidPictures(ArrayList<Picture> pictures) {
        pictures =new ArrayList<>();
        pictures.add(new Picture("https://live.staticflickr.com/8711/16549120663_06ee047a93_b.jpg",
                "Portete","4 days","10 ", "Portete Beach is located in the south of the Esmeraldas province, in the Muisne " +
                "canton. It is visited by hundreds of tourists for its beautiful landscapes and extensive beach, you can enjoy an environment of pure nature and a " +
                "lot of calm. The blue of the sky is reflected in the crystal clear waters of the sea. The white foam of the waves breaks for moments on the fine " +
                "sand, while the wind shakes the leaves of an extensive palm forest along the lonely beach of the island of Portete."));
        pictures.add(new Picture("https://www.turismo.gob.ec/wp-content/uploads/2018/10/ESMERALDAS-ATACAMES-PAISAJES-PLAYAS037.jpg",
                "Atacames","3 days","7 ", "Located on the north coast of Ecuador, 30 km southwest of the city of Esmeraldas." +
                " It is the most visited spa in the country, it has an approximate extension of 5 to 6 kilometers. Atacames has the largest hotel plant in the " +
                "province, which attracts a large number of tourists throughout the year. In the city and on the beach you can find all the facilities for a happy " +
                "tropical vacation."));
        pictures.add(new Picture("https://img.goraymi.com/2018/08/06/03894b70caa8eaeb19e69eb41304fb1d_xl.jpg",
                "Las Palmas","8 days","15 ", "Las Palmas is a booming destination that is expanding rapidly along the " +
                "Ecuadorian coast. Because it is located only 10 minutes from the city of Esmeraldas. Here you can enjoy a classic beach with fine white sand and " +
                "calm waves."));
        pictures.add(new Picture("https://www.decameron.com/images/destinos/ecuador/mompiche/mompiche-001.jpg",
                "Mompiche","15 days","8 ", "Mompiche is a paradise of nature and tranquility, located in the province of " +
                "Esmeraldas, 8 kilometers from Muisne and 400 kilometers from the city of Quito. It is the ideal place for surf lovers, it has one of the longest " +
                "waves in Ecuador, almost a kilometer long. It is one of the last coastal-marine wetlands of Ecuador. Its beautiful landscapes and exquisite food " +
                "make this place ideal to enjoy a perfect day at the beach."));
        pictures.add(new Picture("https://gadmuisne.gob.ec/web/wp-content/uploads/2019/08/muisne12.jpg",
                "Muisne","1 day","2 ", "Muisne Beach is located an hour and a half from the city of Esmeraldas and 48 " +
                "kilometers from Súa, on the Ecuadorian coast. Known as the Emerald Garden, with an approximate extension of 8 kilometers, and 300 meters wide at " +
                "low tide, where you can see the beautiful palm trees full of red crabs that produce the optical illusion that the beach is moving."));
        pictures.add(new Picture("https://lh3.googleusercontent.com/proxy/wbHy-4MS0BcZGp6kSMWoqPIylh0XBsJNBUZft6xbY6GAN3u4Sr3bbgPiTuPemUc-Kj6J2lit6v14ej69T-gHpybZ5-Xwr9tY0eknAjnRn4aJQT00tR_bodr1vy5h",
                "Galera","8 days","4 ", "Cozy and small beach, located in Punta Galera, in the province of Esmeraldas. " +
                "Where you can enjoy bathing, sunbathing and lobster fishing. It is a paradise where you can find tranquility, peace and relax discovering the " +
                "benefits and mysteries of nature. Surrounded by palm trees, it has a small fishing village with possibilities for tourism development."));
        pictures.add(new Picture("https://ec.viajandox.com/uploads/Playa%20Estero%20de%20Pl%C3%A1tano_1.jpg",
                "Estero de Plátano","3 days","3 ", "Estero de Plátano Beach is located on the road to San Francisco, a few " +
                "minutes from the Galera parish, in the Province of Esmeraldas, northeast of Ecuador. It is the perfect spot for humpback whale watching, in mating" +
                " time. It has an extension of 500 meters from the tip of La Corcobada to the Rampidal."));
        return pictures;
    }
}
