package com.example.shosai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.shosai.Dao.*;
import com.example.shosai.domain.Producto;
import com.example.shosai.domain.UploadFile;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping(path = "/productos")
public class ProductosController {
    @Autowired
    private ProductosRepository productosRepository;

    @GetMapping(value = "/agregar")
    public String agregarProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/agregar_producto";
    }

    @GetMapping(value = "/mostrar")
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", productosRepository.findAll());
        return "productos/ver_productos";
    }

    @PostMapping(value = "/eliminar")
    public String eliminarProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttrs) {
        redirectAttrs
                .addFlashAttribute("mensaje", "Eliminado correctamente")
                .addFlashAttribute("clase", "warning");
        productosRepository.deleteById(producto.getId());
        return "redirect:/productos/mostrar";
    }

    // Se colocó el parámetro ID para eso de los errores, ya sé el id se puede recuperar
    // a través del modelo, pero lo que yo quiero es que se vea la misma URL para regresar la vista con
    // los errores en lugar de hacer un redirect, ya que si hago un redirect, no se muestran los errores del formulario
    // y por eso regreso mejor la vista ;)
    @PostMapping(value = "/editar/{id}")
    public String actualizarProducto(@ModelAttribute  Producto producto, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            if (producto.getId() != null) {
                return "productos/editar_producto";
            }
            return "redirect:/productos/mostrar";
        }
        Producto posibleProductoExistente = productosRepository.findFirstByCodigo(producto.getCodigo());

        if (posibleProductoExistente != null && !posibleProductoExistente.getId().equals(producto.getId())) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "Ya existe un producto con ese código")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/productos/agregar";
        }
        productosRepository.save(producto);
        redirectAttrs
                .addFlashAttribute("mensaje", "Editado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/productos/mostrar";
    }

    @GetMapping(value = "/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
        model.addAttribute("producto", productosRepository.findById(id).orElse(null));
        return "productos/editar_producto";
    }

    @PostMapping(value = "/agregar")
    public String guardarProducto(@ModelAttribute  Producto producto, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            return "productos/agregar_producto";
        }
        if (productosRepository.findFirstByCodigo(producto.getCodigo()) != null) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "Ya existe un producto con ese código")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/productos/agregar";
        }
        productosRepository.save(producto);
        redirectAttrs
                .addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/productos/agregar";
    }
    
   //@RequestMapping("/uploadFile")
     @PostMapping(value="productos/uploadFile")
    public String saveFileExcel(MultipartFile file, Model model) throws IOException, CsvValidationException {
        UploadFile upl = new UploadFile();
        List<Producto> lstProducto = upl.guardarFile(file);

        this.productosRepository.saveAll(lstProducto);

        return "redirect:/productos/mostrar";
    }

    public void exportarReporte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
