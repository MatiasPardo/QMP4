# QMP4
Cuarta iteracion de QMP

public class Prenda{
	
}

public class Atuend{

	private List<Prenda> prendas;
}

pulic class Sugerencia{
	
}

public interface Clima{

	public int getClima(String ciudad);
}

public class AccuWeatherApi implements Clima{

	private static List<Map<String, Object>> LISTACLIMASPORCIUDAD;

	private static date FECHAULTIMOLLAMADO

	public int getClima(String ciudad){
		Date llamando = new Date();
		int unaHoraAntesAlLlamado = llamado.getHours()-1; 
		llamando.setHours(unaHoraAntesAlLlamado);
		if(FECHAULTIMOLLAMADO.before(llamando)){ //la idea es actualizar la variable cada 1 hora, para poder ahorrar llamados a la api 
			//la ultima llamada fue hace mas de una hora.. 
			AccuWeatherAPI apiClima = new AccuWeatherAPI();
			List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(“Buenos Aires, Argentina”);  
			return condicionesClimaticas.get(0).get("PrecipitationProbability"); //Devuelve un número del 0 al 1
		}else return LISTACLIMASPORCIUDAD;
	}	
}

public class Sugerencia{
	
}
