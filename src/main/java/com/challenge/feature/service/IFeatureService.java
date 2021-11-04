package com.challenge.feature.service;

import java.util.Collection;

import com.challenge.feature.jsonobject.Feature;

public interface IFeatureService {

	Collection<Feature> findAllFeatures();
	
	Feature findFeatureById(String id);
}
