package de.tudarmstadt.ukp.similarity.dkpro.resource.lexical.ngrams;

import java.util.Map;

import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;

import de.tudarmstadt.ukp.similarity.dkpro.resource.TextSimilarityResourceBase;
import dkpro.similarity.algorithms.lexical.ngrams.WordNGramJaccardMeasure;


public class WordNGramJaccardResource
	extends TextSimilarityResourceBase
{
	public static final String PARAM_N = "N";
	@ConfigurationParameter(name=PARAM_N, mandatory=true)
	private int n;
	
    @SuppressWarnings("unchecked")
    @Override
    public boolean initialize(ResourceSpecifier aSpecifier, Map aAdditionalParams)
        throws ResourceInitializationException
    {
        if (!super.initialize(aSpecifier, aAdditionalParams)) {
            return false;
        }
        
        this.mode = TextSimilarityResourceMode.list;
        
		measure = new WordNGramJaccardMeasure(n);
        
        return true;
    }
}