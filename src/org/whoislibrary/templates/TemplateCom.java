package org.whoislibrary.templates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.whoislibrary.parser.DateOperation;
import org.whoislibrary.parser.ParseOperation;
import org.whoislibrary.parser.StringOperation;
import org.whoislibrary.parser.SkipOperation;
import org.whoislibrary.parser.Template;

/**
 * 
 * Template for com, net and edu domains.
 *  
 * @author Dario Casalinuovo
 * @version 1.0
 *
 */

public final class TemplateCom extends Template {
	private static final DateFormat dateFormat
		= new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

	private static final ParseOperation parse[] = {
		//new SkipOperation(7),
		new StringOperation("   Registrar: ", REGISTRAR),
		new StringOperation("   Whois Server: ", SERVER),
		new StringOperation("   Referral URL: ", REFERRAL),
		new StringOperation("   Name Server: ", NAMESERVER, true),
		new StringOperation("   Status: ", STATUS),

		new DateOperation("   Updated Date: ", LASTUPDATED, dateFormat),
		new DateOperation("   Creation Date: ", CREATION, dateFormat),
		new DateOperation("   Expiration Date: ", EXPIRE, dateFormat)
	};

	private static final ParseOperation availabilityCheck[] = {
		new SkipOperation(7),
		new StringOperation("No match for domain ", AVAILABLE)
	};

	public TemplateCom() {
		super("whois.internic.net");

		setQueryPrefix("domain");
		loadOperations(parse, availabilityCheck);
	}
}
