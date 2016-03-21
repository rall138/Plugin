package crudfactory.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.rldevel.CrudApply;
import com.rldevel.persistence.Column;
import com.rldevel.persistence.Table;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CRUDFactoryHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public CRUDFactoryHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		Table table = new Table("estudiante", "tabla de estudiantes",true);
		Column column = new Column("estudiante_id", false, true);
		table.getColumn_list().add(column);
		column = new Column("estudiante_nombre", false, false);
		table.getColumn_list().add(column);
		column = new Column("estudiante_documento", false, false);		
		table.getColumn_list().add(column);
		
		CrudApply.setPropertyFilePath("/src/crudfactoy.properties");
		CrudApply crudapply = new CrudApply(table);
		crudapply.execute();
		
		return null;
	}
}
