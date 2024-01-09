// If the user selects copy.
case R.id.menu_copy:

// Gets a handle to the clipboard service.
ClipboardManager clipboard = (ClipboardManager)
        getSystemService(Context.CLIPBOARD_SERVICE);
