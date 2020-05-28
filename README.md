# QMP4
Cuarta iteracion de QMP

public class Prenda{
	
	private int temperaturaMaximaDeUso; //dato que tiene la prenda al crearla. 
	
	private List<Temporada> temperadasAcordes(){
		List<Temporada> temporadas = new LinkedList<Temporada>();
		if(Temporada.PRIMAVERA(temperaturaMaximaDeUso)){
			temporadas.add(Temporada.PRIMAVERA);}
		if(Temporada.VERANO(temperaturaMaximaDeUso)){ 
			temporadas.add(Temporada.VERANO);}
		if(Temporada.OTONIO(temperaturaMaximaDeUso)){ 
			temporadas.add(Temporada.OTONIO);}
		if(Temporada.INVIERNO(temperaturaMaximaDeUso)){ 
			temporadas.add(Temporada.INVIERNO);}
		return temporadas;
	}
	
}

public class atuend{

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

public enum Temporada{

	PRIMAVERA{
	public boolean esTemporada(int temperatura){
		return between(temperatura, 15, 25)
	}
	}, VERANO{
	public boolean esTemporada(int temperatura){
		return between(temperatura, 20, 40)
	}
	}, OTOÑO{
	public boolean esTemporada(int temperatura){
		return between(temperatura, 5, 15)
	}
	}, INVIERNO{
	public boolean esTemporada(int temperatura){
		return between(temperatura, -10, 10)
	}
	}
	
}
