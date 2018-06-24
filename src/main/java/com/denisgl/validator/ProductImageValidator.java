package com.denisgl.validator;

import com.denisgl.dtoimpl.HibernateProduct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Stream;

public class ProductImageValidator implements Validator {

    private static final Stream<String> IMAGE_FORMAT_SREAM = Stream.of("image/jpeg", "image/png", "image/gif");

    @Override
    public boolean supports(Class<?> aClass) {
        return HibernateProduct.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        HibernateProduct product = (HibernateProduct) o;

        MultipartFile file = product.getFile();
        if (file == null || StringUtils.isBlank(file.getOriginalFilename())) {
            errors.rejectValue("file", null, "Please select a file to upload!");
            return;
        }

        if (IMAGE_FORMAT_SREAM.noneMatch((f) -> f.equals(file.getContentType()))) {
            errors.rejectValue("file", null, "Please select an image file to upload!");
        }
    }
}
