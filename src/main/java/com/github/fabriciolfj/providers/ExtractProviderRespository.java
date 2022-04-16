package com.github.fabriciolfj.providers;

import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.entity.Extract;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class ExtractProviderRespository implements SaveExtract {

    @Override
    public void persistExtract(Extract extract) {

    }
}
