/**
 */
package pipeline.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.IdResolver.IdResolverExtension;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionFlattenOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SequenceValue.Accumulator;
import org.eclipse.ocl.pivot.values.SetValue;
import pipeline.Job;
import pipeline.Pipeline;
import pipeline.PipelinePackage;
import pipeline.PipelineTables;
import pipeline.Stage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pipeline.impl.PipelineImpl#getStages <em>Stages</em>}</li>
 *   <li>{@link pipeline.impl.PipelineImpl#getAllJobs <em>All Jobs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PipelineImpl extends MinimalEObjectImpl.Container implements Pipeline {
	/**
	 * The cached value of the '{@link #getStages() <em>Stages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStages()
	 * @generated
	 * @ordered
	 */
	protected EList<Stage> stages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipelineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PipelinePackage.Literals.PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Stage> getStages() {
		if (stages == null) {
			stages = new EObjectContainmentEList<Stage>(Stage.class, this, PipelinePackage.PIPELINE__STAGES);
		}
		return stages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Job> getAllJobs() {
		/**
		 * stages->collect(s | s.jobs)->flatten()->asSet()
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtil.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		final /*@NonInvalid*/ List<Stage> stages = this.getStages();
		final /*@NonInvalid*/ OrderedSetValue BOXED_stages = idResolver
				.createOrderedSetOfAll(PipelineTables.ORD_CLSSid_Stage, stages);
		/*@Thrown*/ Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(PipelineTables.SEQ_CLSSid_Job);
		Iterator<Object> ITERATOR_s = BOXED_stages.iterator();
		/*@NonInvalid*/ SequenceValue collect;
		while (true) {
			if (!ITERATOR_s.hasNext()) {
				collect = accumulator;
				break;
			}
			/*@NonInvalid*/ Stage s = (Stage) ITERATOR_s.next();
			/**
			 * s.jobs
			 */
			final /*@NonInvalid*/ List<Job> jobs = s.getJobs();
			final /*@NonInvalid*/ OrderedSetValue BOXED_jobs = idResolver
					.createOrderedSetOfAll(PipelineTables.ORD_CLSSid_Job, jobs);
			//
			for (Object value : BOXED_jobs.flatten().getElements()) {
				accumulator.add(value);
			}
		}
		final /*@NonInvalid*/ SequenceValue flatten = (SequenceValue) CollectionFlattenOperation.INSTANCE
				.evaluate(collect);
		final /*@NonInvalid*/ SetValue asSet = CollectionAsSetOperation.INSTANCE.evaluate(flatten);
		final /*@NonInvalid*/ List<Job> ECORE_asSet = ((IdResolverExtension) idResolver).ecoreValueOfAll(Job.class,
				asSet);
		return (EList<Job>) ECORE_asSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void showStagesNames() {
		throw new UnsupportedOperationException(); // FIXME Unimplemented http://www.example.org/pipeline!Pipeline!showStagesNames()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void showJobsName() {
		throw new UnsupportedOperationException(); // FIXME Unimplemented http://www.example.org/pipeline!Pipeline!showJobsName()
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void showScriptsForStage(final String stageName) {
		throw new UnsupportedOperationException(); // FIXME Unimplemented http://www.example.org/pipeline!Pipeline!showScriptsForStage(String)
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PipelinePackage.PIPELINE__STAGES:
			return ((InternalEList<?>) getStages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PipelinePackage.PIPELINE__STAGES:
			return getStages();
		case PipelinePackage.PIPELINE__ALL_JOBS:
			return getAllJobs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PipelinePackage.PIPELINE__STAGES:
			getStages().clear();
			getStages().addAll((Collection<? extends Stage>) newValue);
			return;
		case PipelinePackage.PIPELINE__ALL_JOBS:
			getAllJobs().clear();
			getAllJobs().addAll((Collection<? extends Job>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case PipelinePackage.PIPELINE__STAGES:
			getStages().clear();
			return;
		case PipelinePackage.PIPELINE__ALL_JOBS:
			getAllJobs().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case PipelinePackage.PIPELINE__STAGES:
			return stages != null && !stages.isEmpty();
		case PipelinePackage.PIPELINE__ALL_JOBS:
			return !getAllJobs().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case PipelinePackage.PIPELINE___SHOW_STAGES_NAMES:
			showStagesNames();
			return null;
		case PipelinePackage.PIPELINE___SHOW_JOBS_NAME:
			showJobsName();
			return null;
		case PipelinePackage.PIPELINE___SHOW_SCRIPTS_FOR_STAGE__STRING:
			showScriptsForStage((String) arguments.get(0));
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //PipelineImpl
