/**
 */
package pipeline;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pipeline.Stage#getJobs <em>Jobs</em>}</li>
 * </ul>
 *
 * @see pipeline.PipelinePackage#getStage()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NoKeywordNames'"
 * @generated
 */
public interface Stage extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Jobs</b></em>' containment reference list.
	 * The list contents are of type {@link pipeline.Job}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jobs</em>' containment reference list.
	 * @see pipeline.PipelinePackage#getStage_Jobs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Job> getJobs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='jobs-&gt;isUnique(job | job.name)'"
	 * @generated
	 */
	boolean UniqueJobNames(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='not(self.name.toLowerCase().matches(\'^(stage|stages|script)$\'))'"
	 * @generated
	 */
	boolean NoKeywordNames(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Stage
