# QMP4
Cuarta iteracion de QMP

public class Prenda{
	
	private int temperaturaMaximaDeUso; //dato que tiene la prenda al crearla. 
/*	
	private List<Temporada> temperadasAcordes(){
		List<Temporada> temporadas = new LinkedList<Temporada>();
		if(Temporada.PRIMAVERA.aplica(temperaturaMaximaDeUso)){
			temporadas.add(Temporada.PRIMAVERA);}
		if(Temporada.VERANO.aplica(temperaturaMaximaDeUso)){ 
			temporadas.add(Temporada.VERANO);}
		if(Temporada.OTONIO.aplica(temperaturaMaximaDeUso)){ 
			temporadas.add(Temporada.OTONIO);}
		if(Temporada.INVIERNO.aplica(temperaturaMaximaDeUso)){ 
			temporadas.add(Temporada.INVIERNO);}
		return temporadas;
	}
*/	
	public boolean esApta(int temperatura){
		return !this.temporadasAcordes().stream.filter(t-> t.aplica(temperatura)).isEmpty()
	}
}

public class atuendo{

	private List<Prenda> prendas;
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
	public static float probabilidadLluvia(String ciudad){
		return this.getClima(ciudad).get("PrecipitationProbability");
	}
	public static float temperatura(String ciudad){
		return this.getClima(ciudad).get("Temperature");
	}
}

public Interface GeneradorSugerencias {

	public List<Atuendo> generarSugerenciaDesde(List<Prenda> prendasAptas){
	}
	
	public List<Prendas> filtrarPrendasAptas(List<Prenda> prendas){
	}
	
}

public class Guardarropa implements GeneradorSugerencias{

	private String ciudad;
	
	private List<Atuendo> atuendos;

	public List<Atuendo> generarSugerenciaDesde(List<Prenda> prendasAptas){
	
	}
	
	public List<Prendas> filtrarPrendasAptas(List<Prenda> prendas){
		
	}
	
}


public enum Temporada{

	PRIMAVERA{
	public boolean aplica(int temperatura){
		return between(temperatura, 15, 25)
	}
	}, VERANO{
	public boolean aplica(int temperatura){
		return between(temperatura, 20, 40)
	}
	}, OTOÑO{
	public boolean aplica(int temperatura){
		return between(temperatura, 5, 15)
	}
	}, INVIERNO{
	public boolean aplica(int temperatura){
		return between(temperatura, -10, 10)
	}
	}
	
}
