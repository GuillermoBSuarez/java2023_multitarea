package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Pais {
	@SerializedName(value="country")
	private String nombrePais;					// Spain
	@SerializedName(value="year_week")
	private String fecha;
	@SerializedName(value="rate_14_day")
	private double incidencia;
	@SerializedName(value="cumulative_count")
	private int acumulados;
	@SerializedName(value="indicator")
	private String indicador;					// cases
}