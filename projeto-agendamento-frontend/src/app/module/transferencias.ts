export interface Transferencias {
    contaOrigem: string,
    contaDestino: string,
    vlrTransferencia: number,
    dtTransferencia: string | null,
    dtAgendamento: string | null,
    taxa: number | null
}
