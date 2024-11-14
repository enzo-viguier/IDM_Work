/**
 */
package pipeline;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pipeline.Pipeline#getStages <em>Stages</em>}</li>
 *   <li>{@link pipeline.Pipeline#getAllJobs <em>All Jobs</em>}</li>
 * </ul>
 *
 * @see pipeline.PipelinePackage#getPipeline()
 * @model
 * @generated
 */
public interface Pipeline extends EObject {
	/**
	 * Returns the value of the '<em><b>Stages</b></em>' containment reference list.
	 * The list contents are of type {@link pipeline.Stage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stages</em>' containment reference list.
	 * @see pipeline.PipelinePackage#getPipeline_Stages()
	 * @model containment="true"
	 * @generated
	 */
	EList<Stage> getStages();

	/**
	 * Returns the value of the '<em><b>All Jobs</b></em>' reference list.
	 * The list contents are of type {@link pipeline.Job}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Jobs</em>' reference list.
	 * @see pipeline.PipelinePackage#getPipeline_AllJobs()
	 * @model volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Job> getAllJobs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void showStagesNames();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void showJobsName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void showScriptsForStage(String stageName);

} // Pipeline
