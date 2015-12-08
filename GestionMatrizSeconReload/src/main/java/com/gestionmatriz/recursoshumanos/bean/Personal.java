/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.recursoshumanos.bean;

import com.digitalpersona.onetouch.DPFPTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

/**
 *
 * @author YESM
 */
public class Personal implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static char MASCULINO = 'M';
    public final static char FEMENINO = 'F';
    public final static char CONBREVETE = 'S';
    public final static char SINBREVETE = 'N';
    private int int_idPersona;
    private String str_codigo;
    private String str_apePaterno;
    private String str_apeMaterno;
    private String str_nombres;
    private String str_dni;
    private String str_carnetExtranjeria;
    private String dte_fechaNacimiento;
    private String str_ciudadNacimiento;
    private String str_telefono;
    private String str_movil;
    private String str_sexo;
    private String str_nacionalidad;
    private String str_correoElectronico;
    private String str_brevete;
    private String str_categoriaBrevete;
    private String str_estadoCivil;
    private String str_direccion;
    private String str_distrito;
    private String str_provincia;
    private String str_departamento;
    private DPFPTemplate bin_huellaDigital_1;
    private DPFPTemplate bin_huellaDigital_2;
    private String str_estado;
    private String dte_fechaCreacion;
    private String str_usuarioCreador;
    private String dte_ultimaModificacion;
    private String str_usuarioModificador;
    private FileInputStream img_foto;

    public byte[] getImgRead() {
        return imgRead;
    }
    public void setImgRead(byte[] imgRead) {
        this.imgRead = imgRead;
    }
    private byte[] imgRead;
    private File fl_foto;

    public File getFl_foto() {
        return fl_foto;
    }
    public void setFl_foto(File fl_foto) {
        this.fl_foto = fl_foto;
    }

    public FileInputStream getImg_foto() {
        return img_foto;
    }
    public void setImg_foto(FileInputStream img_foto) {
        this.img_foto = img_foto;
    }

    public DPFPTemplate getBin_huellaDigital_1() {
        return bin_huellaDigital_1;
    }
    public void setBin_huellaDigital_1(DPFPTemplate bin_huellaDigital_1) {
        this.bin_huellaDigital_1 = bin_huellaDigital_1;
    }

    public DPFPTemplate getBin_huellaDigital_2() {
        return bin_huellaDigital_2;
    }
    public void setBin_huellaDigital_2(DPFPTemplate bin_huellaDigital_2) {
        this.bin_huellaDigital_2 = bin_huellaDigital_2;
    }

    public String getDte_fechaCreacion() {
        return dte_fechaCreacion;
    }
    public void setDte_fechaCreacion(String dte_fechaCreacion) {
        this.dte_fechaCreacion = dte_fechaCreacion;
    }

    public String getDte_fechaNacimiento() {
        return dte_fechaNacimiento;
    }
    public void setDte_fechaNacimiento(String dte_fechaNacimiento) {
        this.dte_fechaNacimiento = dte_fechaNacimiento;
    }

    public String getDte_ultimaModificacion() {
        return dte_ultimaModificacion;
    }
    public void setDte_ultimaModificacion(String dte_ultimaModificacion) {
        this.dte_ultimaModificacion = dte_ultimaModificacion;
    }

    public int getInt_idPersona() {
        return int_idPersona;
    }
    public void setInt_idPersona(int int_idPersona) {
        this.int_idPersona = int_idPersona;
    }

    public String getStr_apeMaterno() {
        return str_apeMaterno;
    }
    public void setStr_apeMaterno(String str_apeMaterno) {
        this.str_apeMaterno = str_apeMaterno;
    }

    public String getStr_apePaterno() {
        return str_apePaterno;
    }
    public void setStr_apePaterno(String str_apePaterno) {
        this.str_apePaterno = str_apePaterno;
    }

    public String getStr_brevete() {
        return str_brevete;
    }
    public void setStr_brevete(String str_brevete) {
        this.str_brevete = str_brevete;
    }

    public String getStr_carnetExtranjeria() {
        return str_carnetExtranjeria;
    }
    public void setStr_carnetExtranjeria(String str_carnetExtranjeria) {
        this.str_carnetExtranjeria = str_carnetExtranjeria;
    }

    public String getStr_categoriaBrevete() {
        return str_categoriaBrevete;
    }
    public void setStr_categoriaBrevete(String str_categoriaBrevete) {
        this.str_categoriaBrevete = str_categoriaBrevete;
    }

    public String getStr_ciudadNacimiento() {
        return str_ciudadNacimiento;
    }
    public void setStr_ciudadNacimiento(String str_ciudadNacimiento) {
        this.str_ciudadNacimiento = str_ciudadNacimiento;
    }

    public String getStr_codigo() {
        return str_codigo;
    }
    public void setStr_codigo(String str_codigo) {
        this.str_codigo = str_codigo;
    }

    public String getStr_correoElectronico() {
        return str_correoElectronico;
    }
    public void setStr_correoElectronico(String str_correoElectronico) {
        this.str_correoElectronico = str_correoElectronico;
    }

    public String getStr_departamento() {
        return str_departamento;
    }
    public void setStr_departamento(String str_departamento) {
        this.str_departamento = str_departamento;
    }

    public String getStr_direccion() {
        return str_direccion;
    }
    public void setStr_direccion(String str_direccion) {
        this.str_direccion = str_direccion;
    }

    public String getStr_distrito() {
        return str_distrito;
    }
    public void setStr_distrito(String str_distrito) {
        this.str_distrito = str_distrito;
    }

    public String getStr_dni() {
        return str_dni;
    }
    public void setStr_dni(String str_dni) {
        this.str_dni = str_dni;
    }

    public String getStr_estado() {
        return str_estado;
    }
    public void setStr_estado(String str_estado) {
        this.str_estado = str_estado;
    }

    public String getStr_estadoCivil() {
        return str_estadoCivil;
    }
    public void setStr_estadoCivil(String str_estadoCivil) {
        this.str_estadoCivil = str_estadoCivil;
    }

    public String getStr_movil() {
        return str_movil;
    }
    public void setStr_movil(String str_movil) {
        this.str_movil = str_movil;
    }

    public String getStr_nacionalidad() {
        return str_nacionalidad;
    }
    public void setStr_nacionalidad(String str_nacionalidad) {
        this.str_nacionalidad = str_nacionalidad;
    }

    public String getStr_nombres() {
        return str_nombres;
    }
    public void setStr_nombres(String str_nombres) {
        this.str_nombres = str_nombres;
    }

    public String getStr_provincia() {
        return str_provincia;
    }
    public void setStr_provincia(String str_provincia) {
        this.str_provincia = str_provincia;
    }

    public String getStr_sexo() {
        return str_sexo;
    }
    public void setStr_sexo(String str_sexo) {
        this.str_sexo = str_sexo;
    }

    public String getStr_telefono() {
        return str_telefono;
    }
    public void setStr_telefono(String str_telefono) {
        this.str_telefono = str_telefono;
    }

    public String getStr_usuarioCreador() {
        return str_usuarioCreador;
    }
    public void setStr_usuarioCreador(String str_usuarioCreador) {
        this.str_usuarioCreador = str_usuarioCreador;
    }

    public String getStr_usuarioModificador() {
        return str_usuarioModificador;
    }
    public void setStr_usuarioModificador(String str_usuarioModificador) {
        this.str_usuarioModificador = str_usuarioModificador;
    }
}
