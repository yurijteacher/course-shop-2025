package ua.com.kisit.courseshop2025.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.courseshop2025.entity.Brands;
import ua.com.kisit.courseshop2025.repository.BrandsRepository;

import java.util.List;

@Service
public class BrandService {

    private final BrandsRepository brandsRepository;

    public BrandService(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }


    public List<Brands> getAllBrands() {
        return brandsRepository.findAll();
    }

    public Brands getBrandById(Long id) {
        return brandsRepository.findById(id).orElse(null);
    }

    public Brands saveBrand(Brands brand) {
        return brandsRepository.save(brand);
    }

    public Brands updateBrand(Brands brand) {
        return brandsRepository.save(brand);
    }

    public void deleteBrand(Long id) {
        brandsRepository.deleteById(id);
    }

    public Brands getBrandsByName(String name) {
        return brandsRepository.findByName(name);
    }

}
