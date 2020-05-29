QMP4
Cuarta iteracion de QMP

public class Prenda{

	private Categoria tipoPrenda;

	private int temperaturaMaximaDeUso; //dato que tiene la prenda al crearla. 

	private List<Temporada> temperadasAcordes(){
		List<Temporada> temporadasAptas = new List<Temporada>();
		for(Temporadas temporada: Temporadas.todas()){
			if(temporada.aplica(temperaturaMaximaDeUso)){
			temporadasAptas.add(temporada);
			}
		}
		return temporadasAptas;

	}

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
		Map<Categoria,List<Prenda>> prendasPorCategoria = new HashMap<<Categoria,List<Prenda>>;
		this.inicializarMapPrendas(prendasPorCategoria);
		for(Prenda prenda: prendasAptas){
			pendasPorCategoria.get(prenda.getTipoPrenda()).add(prenda);
		}
		return this.armarAtuendos(prendasPorCategoria);
	}

	public List<Prendas> filtrarPrendasAptas(List<Prenda> prendas){
		return prendas.stream.filter(p -> p.esApta(AccuWeatherApi.temperatura(this.ciudad));
	}

	private void inicializarMapPrendas(prendasPorCategoria){
		prendasPorCageroria.put(Categoria.SUPERIOR,new List<Prendas>);
		prendasPorCageroria.put(Categoria.INFERIOR,new List<Prendas>);
		prendasPorCageroria.put(Categoria.CALZADO,new List<Prendas>);
		prendasPorCageroria.put(Categoria.ACCESORIOS,new List<Prendas>);
	}

	public List<Atuendo> armarAtuendos(Map<Categoria,List<Prenda>) prendasAgrupadas){
		List<Atuendo> atuendosPosibles = new LinkedList<Atuendo>();
		try{
			atuendosPosibles.add(this.unAtuendo(prendasAgrupadas);
		}catch(Exception e){
			//NO HAGO NADA, O AVISO QUE NO SE PUEDEN GENERAR MAS PRENDAS. 
		}
		return atuendosPosibles;
	}

	public Atuendo unAtuendo(Map<Categoria,List<Prenda> prendasAgrupadas){
		Atuendo atuendo = new Atuendo();
		Prenda prenda = new Prenda();
		for(Categoria cat: Categoria.todas()){
			List<Prenda> prendasUtilizadas = prendasAgrupadas.get(cat);
			if(!prendasUtilizadas.isEmpty()){
				prenda = prendasUtilizadas.stream.findFirst();
				atuendo.set(prenda);
				prendasUtilizadas.remove(prenda);
				prendasAgrupadas.put(cat,prendasUtilizadas);
			}else throw new Exception();
		}
		return prenda;		
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
public List<Temporadas> todas(){ //creo que java tiene funciones que esto lo tiene resueltos
	List<Categorias> temporadas = new LinkedList<Categorias>(); 
 	temporadas.add(PRIMAVERA);
	temporadas.add(VERANO);
	temporadas.add(OTONIO);
	temporadas.add(INVIERNO);
	retunr temporadas;
}

public enum Categorias{

SUPERIOR, INFERIOR, CALZADO, ACCESORIOS;

public List<Categorias> todas(){
	List<Categorias> categorias = new LinkedList<Categorias>();
 	categorias.add(SUPERIOR);
	categorias.add(INFERIOR);
	categorias.add(CALZADO);
	categorias.add(ACCESORIOS);
	retunr categorias;
}