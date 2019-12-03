package opdracht4;

public class AdressServiceImpl implements AdressService {

    @Override
    public void registerAdress(AdressBean adress) {

        System.out.println(adress.getName());
    }
}
