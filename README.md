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

	public Map<String, Object> getClima(String ciudad);
}

public class AccuWeatherApi implements Clima{

	private static Map<String, Object> CLIMA;

	private static date FECHAULTIMOLLAMADO

	public Map<String, Object> getClima(String ciudad){
		Date llamando = new Date();
		int unaHoraAntesAlLlamado = llamado.getHours()-1; 
		llamando.setHours(unaHoraAntesAlLlamado);
		if(FECHAULTIMOLLAMADO.before(llamando)){ //la idea es actualizar la variable cada 1 hora, para poder ahorrar llamados a la api 
			//la ultima llamada fue hace mas de una hora.. 
			AccuWeatherAPI apiClima = new AccuWeatherAPI();
			List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(ciudad);  
			return condicionesClimaticas.get(0);
		}else return CLIMA;
	}	
	public float probabilidadLluvia(String ciudad){
		return this.getClima(ciudad).get("PrecipitationProbability");
	}
	public float temperatura(String ciudad){
		return this.getClima(ciudad).get("Temperature");
	}
}

public class Sugerencia{
	
}
