package utilisationPipelines;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

import pipeline.Job;
import pipeline.Pipeline;
import pipeline.PipelineFactory;
import pipeline.PipelinePackage;
import pipeline.Stage;
import pipeline.impl.PipelineFactoryImpl;

public class FileUtilsPipeline {
	
	public static void sauverModelePipeline(String uri, Pipeline root) {
		   Resource resource = null;
		   try {
		      URI uriUri = URI.createURI(uri);
		      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		      resource = (new ResourceSetImpl()).createResource(uriUri);
		      resource.getContents().add(root);
		      resource.save(null);
		   } catch (Exception e) {
		      System.err.println("ERREUR sauvegarde du modèle : "+e);
		      e.printStackTrace();
		   }
		}
	
	public static Pipeline chargerModelePipeline(String uri) {
				Resource resource = null;
				   try {
				      URI uriUri = URI.createURI(uri);
				      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
				      resource = (new ResourceSetImpl()).createResource(uriUri);
				      XMLResource.XMLMap xmlMap = new XMLMapImpl();
				      xmlMap.setNoNamespacePackage(PipelinePackage.eINSTANCE);
				      java.util.Map options = new java.util.HashMap();
				      options.put(XMLResource.OPTION_XML_MAP, xmlMap);
				      resource.load(options);
				   }
				   catch(Exception e) {
				      System.err.println("ERREUR chargement du modèle : "+e);
				      e.printStackTrace();
				   }
				   return (Pipeline) resource.getContents().get(0);
				}
	
	public static void main(String[] args) {
		Pipeline p=FileUtilsPipeline.chargerModelePipeline("model/Pipeline1.xmi");
		showStageNames(p);
		showJobNames(p);
		showScriptsForStage(p, "build");
	}
	
	public static void showStageNames(Pipeline p) {
		p.getStages().stream()
			.forEach(s->System.out.println(s.getName()));
	}
	
	public static void showJobNames(Pipeline p) {
		p.getStages().stream()
					 .forEach(s -> s.getJobs().stream()
							 				  .forEach(j -> System.out.println(j.getName())));
	}
	
	public static void showScriptsForStage(Pipeline p, String stageName) {
		p.getStages().stream()
					 .filter(s -> s.getName().equals(stageName))
					 .forEach(s -> s.getJobs().stream()
							    			  .forEach(j -> j.getScript().stream()
							    					  					 .forEach(script -> System.out.println(script))));
	}
	
	
}

